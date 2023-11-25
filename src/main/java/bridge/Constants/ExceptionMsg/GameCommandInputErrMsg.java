package bridge.Constants.ExceptionMsg;

public enum GameCommandInputErrMsg {
    ASK_NO_EMPTY_INPUT("빈칸은 허용되지 않습니다."),
    ASK_NO_WHITE_SPACE("공백 없이 입력해주세요."),
    ASK_ONLY_VALID_CHAR("문자 형식의 %s 혹은 %s만 입력 가능합니다.");

    private String message;

    GameCommandInputErrMsg(String message){
        this.message = PrefixMsg.ERROR_MSG.getMessage() + message;
    }

    public String getMessage() {
        return message;
    }
}