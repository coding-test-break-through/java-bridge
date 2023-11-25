package bridge;

public class Game {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private BridgeGame bridgeGame;
    private boolean isGameSet = false;
    private boolean isSuccess = false;
    private int bridgeSize;

    void start() {
        setupBridgeDetails();
        while (!isGameSet) {
            play();
        }
        showResult();
    }

    private void setupBridgeDetails() {
        outputView.printStart();
        outputView.printLengthRequestMessage();
        bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    private void play() {
        moving();
        checkEnd();
    }

    private void moving() {
        outputView.printMovingRequestMessage();
        boolean canMove = bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getUpRoad(), bridgeGame.getDownRoad());
        if (!canMove) {
            outputView.printGameCommandRequestMessage();
            isGameSet = bridgeGame.retry(inputView.readGameCommand());
        }
    }

    private void checkEnd() {
        if (bridgeGame.getLocation() == bridgeSize) {
            isSuccess = true;
            isGameSet = true;
        }
    }

    private void showResult() {
        outputView.printResultStart();
        outputView.printMap(bridgeGame.getUpRoad(), bridgeGame.getDownRoad());
        outputView.printResult(isSuccess, bridgeGame.getAttemptCount());
    }
}