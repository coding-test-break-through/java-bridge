package bridge.view;

import bridge.dto.GameResultDto;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> playerRoute) {
        int playerPosition = playerRoute.size();
        List<String> upper = new ArrayList<>(playerPosition);
        List<String> lower = new ArrayList<>(playerPosition);
        for (int bridgeIndex = 0; bridgeIndex < playerPosition; bridgeIndex++) {
            String simbol = getSimbol(bridge, playerRoute, bridgeIndex);
            addSimbol(playerRoute, upper, lower, bridgeIndex, simbol);
        }
        System.out.println("[ " + String.join(" | ", upper) + " ]");
        System.out.println("[ " + String.join(" | ", lower) + " ]");
        System.out.println();
    }

    private static String getSimbol(List<String> bridge, List<String> playerRoute, int bridgeIndex) {
        String simbol = "X";
        if (bridge.get(bridgeIndex).equals(playerRoute.get(bridgeIndex))) {
            simbol = "O";
        }
        return simbol;
    }

    private static void addSimbol(List<String> playerRoute, List<String> upper, List<String> lower, int bridgeIndex,
                                  String simbol) {
        if ("U".equals(playerRoute.get(bridgeIndex))) {
            upper.add(simbol);
            lower.add(" ");
        }
        if ("D".equals(playerRoute.get(bridgeIndex))) {
            lower.add(simbol);
            upper.add(" ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResultDto gameResultDto) {
        System.out.println("최종 게임 결과");
        printMap(gameResultDto.getBridge(), gameResultDto.getPlayerRoute());
        System.out.printf(String.format("게임 성공 여부: %s\n", gameResultDto.getGameResultMessage()));
        System.out.printf(String.format("총 시도한 횟수: %d\n", gameResultDto.getGameTryCount()));
    }

    public void printErrorMessage(String message) {
        System.out.printf("[ERROR] %s%n", message);
    }
}
