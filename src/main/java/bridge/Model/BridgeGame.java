package bridge.Model;

import static bridge.Constants.DomainConstants.FINAL_GAME_CLEAR;
import static bridge.Constants.DomainConstants.FINAL_GAME_FAIL;
import static bridge.Constants.DomainConstants.MAP_PRINT_FAIL;
import static bridge.Constants.DomainConstants.MAP_PRINT_SUCCESS;
import static bridge.Constants.DomainConstants.MOVE_DIRECTION_DOWN;
import static bridge.Constants.DomainConstants.MOVE_DIRECTION_UP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BridgeGame {
    private List<String> bridgeMap;
    private List<String> topRow;
    private List<String> bottomRow;
    private Integer tryNum;

    public BridgeGame(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
        this.topRow = new ArrayList<>();
        this.bottomRow = new ArrayList<>();
        this.tryNum = 0;
    }

    public void retry() {
        tryNum ++;
        topRow.clear();
        bottomRow.clear();
    }

    public boolean move(String userInput) {
        int currentRound = topRow.size();
        if (userInput.equals(bridgeMap.get(currentRound))) {
            return recordSuccess(userInput);
        }
            return recordFail(userInput);
    }

    private boolean recordSuccess(String userInput){
        recordSucceedInTopRow(userInput);
        recordSucceedInBottomRow(userInput);
        return true;
    }

    private boolean recordFail(String userInput){
        recordFailInTopRow(userInput);
        recordFailInBottomRow(userInput);
        return false;
    }

    private void recordSucceedInTopRow(String userInput){
        if (MOVE_DIRECTION_UP.equals(userInput)){
            topRow.add(MAP_PRINT_SUCCESS);
            bottomRow.add("   ");
        }
    }

    private void recordSucceedInBottomRow(String userInput){
        if (MOVE_DIRECTION_DOWN.equals(userInput)){
            topRow.add("   ");
            bottomRow.add(MAP_PRINT_SUCCESS);
        }
    }

    private void recordFailInTopRow(String userInput){
        if (MOVE_DIRECTION_UP.equals(userInput)){
            topRow.add(MAP_PRINT_FAIL);
            bottomRow.add("   ");
        }
    }
    private void recordFailInBottomRow(String userInput){
        if (MOVE_DIRECTION_DOWN.equals(userInput)){
            bottomRow.add(MAP_PRINT_FAIL);
            topRow.add("   ");
        }
    }

    private boolean isRowNotContainsX(){
        return !topRow.contains(MAP_PRINT_FAIL) && !bottomRow.contains(MAP_PRINT_FAIL);
    }



    public boolean isGameClear() {
        if(bridgeMap.size() == topRow.size() && isRowNotContainsX()){;
            return true;
        }
        return false;
    }

    public List<String> getTopRow() {
        return topRow;
    }

    public List<String> getBottomRow() {
        return bottomRow;
    }

    public int getTryNum() {
        return tryNum;
    }
}
