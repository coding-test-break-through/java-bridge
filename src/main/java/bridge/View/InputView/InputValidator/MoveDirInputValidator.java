package bridge.View.InputView.InputValidator;

import static bridge.Constants.DomainConstants.MOVE_DIRECTION_DOWN;
import static bridge.Constants.DomainConstants.MOVE_DIRECTION_UP;
import static bridge.Constants.ExceptionMsg.MoveInputErrMsg.*;

public class MoveDirInputValidator implements Validator{
    public final String WHITE_SPACE = " ";
    private final String MOVE_DIR_REGULAR_EXPRESSION = "^[UD]$";

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
        if (!userInput.matches(MOVE_DIR_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(String.format(ASK_ONLY_VALID_CHAR.getMessage(), MOVE_DIRECTION_UP, MOVE_DIRECTION_DOWN));
        }
    }
}
