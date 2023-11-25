package bridge.Constants;

public enum OutputPromptMsg {
    GAME_RESULT("게임 성공 여부: %s"),
    TOTAL_TRY_NUMBER("총 시도한 횟수: %d");

    private String message;

    OutputPromptMsg(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
