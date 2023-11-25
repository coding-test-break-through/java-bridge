package bridge;

import java.util.Objects;

public class Validator {
    static void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    static void checkBridgeRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    static void checkMoving(String input) {
        if (Objects.equals(input, "U") || Objects.equals(input, "D")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다.");
    }

    static void checkGameCommand(String input) {
        if (Objects.equals(input, "R") || Objects.equals(input, "Q")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 재시도 여부는 R 또는 Q여야 합니다.");
    }

}
