package bridge;

public class Game {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeGame bridgeGame;
    boolean isGameSet = false;
    boolean isSuccess = false;
    int bridgeSize;

    void start() {
        setupBridgeDetails();
        while (!isGameSet) {
            play();
        }
        System.out.println("최종 게임 결과");
        bridgeGame.printResult();
        outputView.printResult(isSuccess, bridgeGame.getAttemptCount());
    }

    void setupBridgeDetails() {
        outputView.printStart();
        outputView.printLengthRequestMessage();
        bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    void play() {
        outputView.printMovingRequestMessage();
        if (!bridgeGame.move(inputView.readMoving())) {
            outputView.printGameCommandRequestMessage();
            isGameSet = bridgeGame.retry(inputView.readGameCommand());
        }
        if (bridgeGame.getLocation() == bridgeSize) {
            isSuccess = true;
            isGameSet = true;
        }
    }
}