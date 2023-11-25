package bridge.Constants.ExceptionMsg;

public enum BridgeSizeInputErrMsg {
    ASK_NO_EMPTY_INPUT("빈칸은 허용되지 않습니다. 3부터 20 사이의 숫자를 입력해주세요"),
    ASK_NO_WHITE_SPACE("공백 없이 숫자를 입력해주세요. 3부터 20 사이의 숫자를 입력해주세요"),
    ASK_INPUT_IN_VALID_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private String message;

    BridgeSizeInputErrMsg(String message){
        this.message = PrefixMsg.ERROR_MSG.getMessage() + message;
    }

    public String getMessage() {
        return message;
    }
}
