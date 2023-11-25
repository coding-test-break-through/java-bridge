package bridge.view.output;

public enum Output {

    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다. \n"),
    PLEASE_INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    START_BRIDGE_GAME_MESSAGE("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"),
    RESTART_OR_NOT_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: $s)"),
    ;

    final String message;

    Output(String message) {
        this.message = message;
    }
}
