package bridge.view.input;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return new InputValidator().validateBridgeSize(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return new InputValidator().validateBridgeSelect(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return new InputValidator().validateRestartOrNot(Console.readLine());
    }
}
