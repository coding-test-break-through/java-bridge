package bridge.View.InputView.InputValidator;

import static bridge.Constants.DomainConstants.*;
import static bridge.Constants.ExceptionMsg.GameCommandInputErrMsg.*;

public class GameCommandInputValidator implements Validator{
    public final String WHITE_SPACE = " ";
    private final String GAME_RETRY_COMMAND_REGULAR_EXPRESSION = "^[RQ]$";

    @Override
    public void validate(String userInput){
        isNotEmpty(userInput);
        containsNoWhiteSpace(userInput);
        isRightFormat(userInput);
    }

    public void isNotEmpty(String userInput) throws IllegalArgumentException{
        if(userInput.isEmpty()){
            throw new IllegalArgumentException(ASK_NO_EMPTY_INPUT.getMessage());
        }
    }

    public void containsNoWhiteSpace(String userInput) throws IllegalArgumentException{
        if(userInput.contains(WHITE_SPACE)){
            throw new IllegalArgumentException(ASK_NO_WHITE_SPACE.getMessage());
        }
    }

    public void isRightFormat(String userInput) throws IllegalArgumentException{
        if (!userInput.matches(GAME_RETRY_COMMAND_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(
                    String.format(ASK_ONLY_VALID_CHAR.getMessage(), GAME_COMMAND_RETRY, GAME_COMMAND_QUIT));
        }
    }
}
