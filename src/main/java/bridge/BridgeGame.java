package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String UPPER_BRIDGE = "U";
    private static final String LOWER_BRIDGE = "D";
    private static final String START_ROAD = "[ ";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";
    private static final String EMPTY = " ";
    private static final String ROAD_SEPARATOR = " | ";

    private final List<String> bridgeStatus;
    private int location = 0;
    private int attemptCount;
    private StringBuilder upRoad;
    private StringBuilder downRoad;

    BridgeGame(int input) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeStatus = bridgeMaker.makeBridge(input);
        attemptCount = 1;
        upRoad = new StringBuilder(START_ROAD);
        downRoad = new StringBuilder(START_ROAD);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        boolean canMove = Objects.equals(bridgeStatus.get(location), input);
        updateRoad(canMove);
        location++;
        return canMove;
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
            upRoad = new StringBuilder(START_ROAD);
            downRoad = new StringBuilder(START_ROAD);
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

    public String getUpRoad() {
        return upRoad.toString();
    }

    public String getDownRoad() {
        return downRoad.toString();
    }

    private void updateRoad(boolean canMove) {
        if(canMove) {
            updateSuccessRoad();
            return;
        }
        updateFailureRoad();
    }

    private void updateSuccessRoad() {
        if (bridgeStatus.get(location).equals(UPPER_BRIDGE)) {
            appendRoad(SUCCESS, EMPTY);
        }
        if (bridgeStatus.get(location).equals(LOWER_BRIDGE)) {
            appendRoad(EMPTY, SUCCESS);
        }
    }

    private void updateFailureRoad() {
        if (bridgeStatus.get(location).equals(UPPER_BRIDGE)) {
            appendRoad(EMPTY, FAIL);
        }
        if (bridgeStatus.get(location).equals(LOWER_BRIDGE)) {
            appendRoad(FAIL, EMPTY);
        }
    }

    private void appendRoad(String upSymbol, String downSymbol) {
        upRoad.append(upSymbol).append(ROAD_SEPARATOR);
        downRoad.append(downSymbol).append(ROAD_SEPARATOR);
    }
}