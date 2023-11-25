package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.dto.BridgeMapDto;
import bridge.domain.dto.BridgeResultDto;
import bridge.formatter.OutputFormatter;
import bridge.util.BridgeConstant;
import bridge.view.input.InputView;
import bridge.view.output.Output;
import bridge.view.output.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    private int totalGameCount;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeCount = constructBridge();

        playGame(BridgeGame.playOf(bridgeMaker, bridgeCount), bridgeCount);
    }

    private int constructBridge() {
        outputView.printMessage(Output.START_BRIDGE_GAME);
        return inputBridgeSize();
    }

    private void playGame(BridgeGame bridgeGame, int gameCount) {
        List<BridgeMapDto> bridgeResults = new ArrayList<>();

        for (int index = 1; index <= gameCount; index++) {
            String selectBridge = inputBridgeSelect();
            bridgeResults.add(bridgeGame.move(selectBridge, index));
            this.totalGameCount++;

            if (!showSuccessResult(bridgeResults)) {
                showReGameOrNot(bridgeGame, gameCount);
                break;
            }
        }
        showFinalResult(bridgeResults);
    }

    private boolean showSuccessResult(List<BridgeMapDto> bridgeMaps) {
        System.out.println();
        BridgeResultDto results = new OutputFormatter().formatResult(bridgeMaps);
        outputView.printMap(results);

        if (results.isEnds()) {
            return false;
        }
        return true;
    }

    private void showReGameOrNot(BridgeGame bridgeGame, int gameCount) {
        String restartOrNot = inputRestartOrNot();

        if (BridgeConstant.BRIDGE_GAME_RESTART.equals(restartOrNot)) {
            playGame(bridgeGame, gameCount);
        }
    }

    private void showFinalResult(List<BridgeMapDto> bridgeMaps) {
        BridgeResultDto results = new OutputFormatter().formatResult(bridgeMaps);

        outputView.printMessage(Output.FINAL_RESULT);
        outputView.printMap(results);

        outputView.printfMessage(Output.IS_GAME_SUCCEED_MESSAGE, new OutputFormatter().isSucceedGame(results.isEnds()));
        outputView.println();
        outputView.printfMessage(Output.TOTAL_PLAY_TIME_MESSAGE, totalGameCount);
    }

    private String inputRestartOrNot() {
        outputView.printfMessage(Output.RESTART_OR_NOT_MESSAGE, BridgeConstant.BRIDGE_GAME_RESTART,
                BridgeConstant.BRIDGE_GAME_QUIT);

        return receiveValidatedInput(inputView::readGameCommand);
    }

    private int inputBridgeSize() {
        outputView.printMessage(Output.PLEASE_INPUT_BRIDGE_LENGTH);
        return receiveValidatedInput(inputView::readBridgeSize);
    }

    private String inputBridgeSelect() {
        outputView.printfMessage(Output.START_BRIDGE_GAME_MESSAGE, BridgeConstant.UP_BRIDGE_STATUS,
                BridgeConstant.DOWN_BRIDGE_STATUS);

        return receiveValidatedInput(inputView::readMoving);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return receiveValidatedInput(inputSupplier);
        }
    }
}
