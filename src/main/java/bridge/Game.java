package bridge;

public class Game {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    void start() {
        setupBridgeDetails();

    }

    void setupBridgeDetails() {
        outputView.printStart();
        outputView.printLengthRequestMessage();
        int bridgeSize = inputView.readBridgeSize();

    }
}
