package bridge.validator;

import bridge.util.BridgeConstant;
import bridge.view.input.error.InputError;
import bridge.view.input.error.InputIllegalArgumentException;

public class InputValidator {

    private final static int MIN_RANGE_NUMBER = BridgeConstant.MIN_BRIDGE_NUMBER;
    private final static int MAX_RANGE_NUMBER = BridgeConstant.MAX_BRIDGE_NUMBER;

    public int validateBridgeSize(String inputValue) {
        validateNotBlank(inputValue);
        int tryNumber = validateIsNumber(inputValue);
        validateInRangeNumber(tryNumber);

        return tryNumber;
    }

    public String validateBridgeSelect(String inputValue) {
        validateNotBlank(inputValue);
        validateInRangeString(inputValue);

        return inputValue.trim();
    }

    public String validateRestartOrNot(String inputValue) {
        validateNotBlank(inputValue);
        validateInRangeRestartSelection(inputValue);

        return inputValue.trim();
    }

    private int validateIsNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new InputIllegalArgumentException(InputError.MUST_BE_NUMBER);
        }
    }

    private void validateNotBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new InputIllegalArgumentException(InputError.MUST_BE_NUMBER);
        }
    }

    private void validateInRangeNumber(int tryNumber) {
        if (isInRangeNumber(tryNumber)) {
            throw new InputIllegalArgumentException(InputError.NOT_IN_RANGE_NUMBER, MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        }
    }

    private void validateInRangeString(String selectBridge) {
        if (!isInRangeBridgeSelection(selectBridge)) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_BRIDGE_SELECT);
        }
    }

    private void validateInRangeRestartSelection(String inputValue) {
        if (!isInRangeRestartSelection(inputValue)) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_BRIDGE_SELECT);
        }
    }

    private boolean isInRangeNumber(int tryNumber) {
        return tryNumber < MIN_RANGE_NUMBER || tryNumber > MAX_RANGE_NUMBER;
    }

    private boolean isInRangeBridgeSelection(String selectBridge) {
        return BridgeConstant.UP_BRIDGE_STATUS.equals(selectBridge) || BridgeConstant.DOWN_BRIDGE_STATUS.equals(
                selectBridge);
    }

    private boolean isInRangeRestartSelection(String selectBridge) {
        return BridgeConstant.BRIDGE_GAME_RESTART.equals(selectBridge) || BridgeConstant.BRIDGE_GAME_QUIT.equals(
                selectBridge);
    }
}