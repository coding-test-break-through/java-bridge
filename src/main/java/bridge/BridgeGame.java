package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final List<String> bridgeStatus;
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    int location = 0;
    int attemptCount;
    StringBuilder upRoad;
    StringBuilder downRoad;

    BridgeGame(int input) {
        bridgeStatus = bridgeMaker.makeBridge(input);
        attemptCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        if (Objects.equals(bridgeStatus.get(location), input)) {
            location++;
            printLocationTrue();
            return true;
        }
        printLocationFalse();
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if (Objects.equals(input, "R")) {
            attemptCount++;
            location = 0;
            return false;
        }
        return true;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getLocation() {
        return location;
    }

    void printLocationTrue() {
        upRoad = new StringBuilder("[");
        downRoad = new StringBuilder("[");
        for (int i = 0; i < location; i++) {
            if(Objects.equals(bridgeStatus.get(i), "U")) {
                upRoad.append(" O |");
                downRoad.append("   |");
            }
            if (Objects.equals(bridgeStatus.get(i), "D")) {
                upRoad.append("   |");
                downRoad.append(" O |");
            }
        }
        upRoad = new StringBuilder(upRoad.substring(0, upRoad.length() - 2) + " ]");
        downRoad = new StringBuilder(downRoad.substring(0, downRoad.length() - 2) + " ]");
        System.out.println(upRoad);
        System.out.println(downRoad);
        System.out.println();
    }

    void printLocationFalse() {
        upRoad = new StringBuilder("[");
        downRoad = new StringBuilder("[");
        for (int i = 0; i < location; i++) {
            if(Objects.equals(bridgeStatus.get(i), "U")) {
                upRoad.append(" O |");
                downRoad.append("   |");
            }
            if (Objects.equals(bridgeStatus.get(i), "D")) {
                upRoad.append("   |");
                downRoad.append(" O |");
            }
        }
        if(Objects.equals(bridgeStatus.get(location), "U")) {
            upRoad.append("   |");
            downRoad.append(" X |");
        }
        if (Objects.equals(bridgeStatus.get(location), "D")) {
            upRoad.append(" X |");
            downRoad.append("   |");
        }
        upRoad = new StringBuilder(upRoad.substring(0, upRoad.length() - 2) + " ]");
        downRoad = new StringBuilder(downRoad.substring(0, downRoad.length() - 2) + " ]");
        System.out.println(upRoad);
        System.out.println(downRoad);
        System.out.println();
    }

    void printResult() {
        System.out.println(upRoad);
        System.out.println(downRoad);
        System.out.println();
    }
}
