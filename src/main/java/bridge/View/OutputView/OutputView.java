package bridge.View.OutputView;

import static bridge.Constants.DomainConstants.*;
import static bridge.Constants.OutputPromptMsg.GAME_FINAL_RESULT;
import static bridge.Constants.OutputPromptMsg.GAME_RESULT;
import static bridge.Constants.OutputPromptMsg.TOTAL_TRY_NUMBER;

import bridge.Model.BridgeGame;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    // 맵 이동 결과를 출력한다
    public void printMap(BridgeGame game) {
        List<String> topRow = game.getTopRow();
        List<String> bottomRow = game.getBottomRow();

        System.out.println(MAP_PRINT_START
                + String.join(MAP_PRINT_SPLIT, topRow)
                + MAP_PRINT_END);
        System.out.println(MAP_PRINT_START
                + String.join(MAP_PRINT_SPLIT, bottomRow)
                + MAP_PRINT_END);
    }

    public String gameClearOrFail(BridgeGame game){
        if(game.isGameClear()){
            return FINAL_GAME_CLEAR;
        }
        return FINAL_GAME_FAIL;
    }

    // 게임의 최종 결과를 정해진 형식에 맞춰 출력한다
    public void printResult(BridgeGame game) {
        System.out.println(GAME_FINAL_RESULT.getMessage());
        System.out.println(String.format(GAME_RESULT.getMessage(), gameClearOrFail(game)));
        System.out.println(String.format(TOTAL_TRY_NUMBER.getMessage(), game.getTryNum()));
    }
}