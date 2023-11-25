package bridge.View.InputView.InputValidator;

import static bridge.Constants.DomainConstants.*;
import static bridge.Constants.ExceptionMsg.BridgeSizeInputErrMsg.*;

public class BridgeSizeInputValidator implements Validator{
    public final String WHITE_SPACE = " ";
    private final String NUMBER_REGULAR_EXPRESSION = "^[0-9]+$";

    @Override
    public void validate(String userInput){
        isNotEmpty(userInput);
        containsNoWhiteSpace(userInput);
        isNumber(userInput);
        isBetweenValidRange(userInput);
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

    public void isNumber(String userInput) throws IllegalArgumentException {
        if (!userInput.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ASK_INPUT_IN_NUMBER.getMessage());
        }
    }

    public void isBetweenValidRange(String userInput) throws IllegalArgumentException{
        if(Integer.parseInt(userInput) < MIN_BRIDGE_SIZE
                || Integer.parseInt(userInput) > MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException(ASK_INPUT_IN_VALID_SIZE.getMessage());
        }
    }

}
