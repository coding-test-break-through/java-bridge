package bridge;

import java.util.Objects;

public class Validator {
    private static final String ERROR_INVALID_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_INVALID_MOVING = "[ERROR] 이동할 칸은 U 또는 D여야 합니다.";
    private static final String ERROR_INVALID_GAME_COMMAND = "[ERROR] 재시도 여부는 R 또는 Q여야 합니다.";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    static void checkBridgeSize(String input) {
        Validator.checkInteger(input);
        int bridgeSize = Integer.parseInt(input);
        Validator.checkBridgeRange(bridgeSize);
    }

    static void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }

    static void checkBridgeRange(int input) {
        if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }

    static void checkMoving(String input) {
        if (Objects.equals(input, "U") || Objects.equals(input, "D")) {
            return;
        }
        throw new IllegalArgumentException(ERROR_INVALID_MOVING);
    }

    static void checkGameCommand(String input) {
        if (Objects.equals(input, "R") || Objects.equals(input, "Q")) {
            return;
        }
        throw new IllegalArgumentException(ERROR_INVALID_GAME_COMMAND);
    }
}