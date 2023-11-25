package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
        validateBridgeSize(bridgeSize);
        System.out.println();
        return bridgeSize;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = readLine();
        validateMoving(moving);

        return moving;
    }

    private void validateMoving(String moving) {
        if (!("U".equals(moving)) && !("D".equals(moving))) {
            throw new IllegalArgumentException("U 또는 D 만 입력 가능합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = readLine();
        validateGameCommand(gameCommand);

        return gameCommand;
    }

    private void validateGameCommand(String moving) {
        if (!("R".equals(moving)) && !("Q".equals(moving))) {
            throw new IllegalArgumentException("R 또는 Q 만 입력 가능합니다.");
        }
    }
}
