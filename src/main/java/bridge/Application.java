package bridge;

import bridge.controller.BridgeController;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        new BridgeController(inputView, outputView).run();
    }
}
