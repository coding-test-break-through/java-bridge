package bridge.View.InputView;

import static bridge.Constants.DomainConstants.GAME_COMMAND_QUIT;
import static bridge.Constants.DomainConstants.GAME_COMMAND_RETRY;
import static bridge.Constants.DomainConstants.MOVE_DIRECTION_DOWN;
import static bridge.Constants.DomainConstants.MOVE_DIRECTION_UP;
import static bridge.Constants.InputPromptMsg.ASK_BRIDGE_SIZE;
import static bridge.Constants.InputPromptMsg.ASK_GAME_RETRY;
import static bridge.Constants.InputPromptMsg.ASK_MOVE_DIRECTION;
import static bridge.Constants.InputPromptMsg.INITIAL_NOTICE;

import bridge.View.InputView.InputValidator.BridgeSizeInputValidator;
import bridge.View.InputView.InputValidator.MoveDirInputValidator;
import bridge.View.InputView.InputValidator.GameCommandInputValidator;
import bridge.View.InputView.InputValidator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    Validator bridgeSizeInputValidator = new BridgeSizeInputValidator();
    Validator moveDirInputValidator = new MoveDirInputValidator();
    Validator retryInputValidator = new GameCommandInputValidator();

    public InputView(){
        System.out.println(INITIAL_NOTICE.getMessage());
    }

    // 다리의 길이를 입력받는다.
    public Integer readBridgeSize(){
        return Integer.parseInt(inputWithValidation(
                ASK_BRIDGE_SIZE.getMessage(),
                bridgeSizeInputValidator));
    }

    // 사용자가 이동할 칸을 입력받는다.
    public String readMoving() {
        return inputWithValidation(
                String.format(ASK_MOVE_DIRECTION.getMessage(), MOVE_DIRECTION_UP, MOVE_DIRECTION_DOWN),
                moveDirInputValidator);
    }

    // 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
    public String readGameCommand() {
        return inputWithValidation(
                String.format(ASK_GAME_RETRY.getMessage(), GAME_COMMAND_RETRY, GAME_COMMAND_QUIT),
                retryInputValidator);
    }

    private String inputWithValidation(String message, Validator validator) {
        while (true) {
            try {
                System.out.println(message);
                String userInput = Console.readLine();
                validator.validate(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
