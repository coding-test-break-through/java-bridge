package bridge.view.input.error;

public enum InputError {

    MUST_BE_NUMBER("입력한 값이 숫자여야 합니다."),
    NOT_IN_RANGE_NUMBER("가능한 범위의 숫자가 아닙니다. %s과 %s 사이의 숫자를 입력해주세요."),

    NOT_POSSIBLE_BRIDGE_SELECT("선택 가능한 다리가 아닙니다.");

    final String message;

    InputError(String message) {
        this.message = message;
    }
}
