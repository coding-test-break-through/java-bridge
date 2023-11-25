package bridge.View.OutputView;

import static bridge.Constants.DomainConstants.*;
import static bridge.Constants.OutputPromptMsg.GAME_RESULT;
import static bridge.Constants.OutputPromptMsg.TOTAL_TRY_NUMBER;

import bridge.Model.BridgeGame;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    // 맵 이동 결과를 출력한다
    public void printMap(BridgeGame game) {
        Map<String, Boolean> resultMap = game.getResultMap();
        List<String> bridgeMap = game.getBridgeMap();

        StringBuilder topRow = new StringBuilder(MAP_PRINT_START);
        StringBuilder bottomRow = new StringBuilder(MAP_PRINT_START);

        for (Entry<String, Boolean> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            Boolean isMoveSucceed = entry.getValue();

            String moveResult = MAP_PRINT_SUCCESS;
            if (!isMoveSucceed){
                moveResult = MAP_PRINT_FAIL;
            }
            if (MOVE_DIRECTION_UP.equals(key)) {
                handleTop(topRow, bottomRow, moveResult);
            }

            if (MOVE_DIRECTION_DOWN.equals(key)) {
                handleBottom(topRow, bottomRow, moveResult);
            }
        }

        topRow.append(MAP_PRINT_END);
        bottomRow.append(MAP_PRINT_END);

        System.out.println(topRow);
        System.out.println(bottomRow);
    }

    private void handleTop(StringBuilder topRow, StringBuilder bottomRow, String valueStr) {
        topRow.append(valueStr).append(MAP_PRINT_SPLIT);
        bottomRow.append(MAP_PRINT_SPLIT);
    }

    private void handleBottom(StringBuilder topRow, StringBuilder bottomRow, String valueStr) {
        bottomRow.append(valueStr).append(MAP_PRINT_SPLIT);
        topRow.append(MAP_PRINT_SPLIT);
    }

    // 게임의 최종 결과를 정해진 형식에 맞춰 출력한다
    public void printResult(BridgeGame game) {

    }

    public void printFinalGameStatistics(BridgeGame game){
        System.out.println(GAME_RESULT.getMessage());
        System.out.println(String.format(TOTAL_TRY_NUMBER.getMessage(), game.getRetryNum()));
    }
}
