package bridge;

import static bridge.Constants.DomainConstants.GAME_COMMAND_QUIT;
import static bridge.Constants.DomainConstants.GAME_COMMAND_RETRY;

import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.View.InputView.InputView;
import bridge.View.OutputView.OutputView;
import java.util.List;
import java.util.Map;

public class Controller {

    private Integer bridgeSize;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    public void gameProcess(){
        bridgeSize = inputView.readBridgeSize();
        String gameCommand = inputView.readGameCommand();
        List<String> bridgeMap = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        playGame(bridgeGame);
    }


    private void continueOneRound(BridgeGame bridgeGame) {
        boolean playerAlive = true;
        do {
            String moveDir = inputView.readMoving();
            playerAlive = bridgeGame.move(moveDir);
            outputView.printMap(bridgeGame);
        } while(!playerAlive);
    }

    private void playGame(BridgeGame bridgeGame){
        boolean retry = inputView.readGameCommand().equals(GAME_COMMAND_RETRY);
        do {
            bridgeGame.retry();
            continueOneRound(bridgeGame);
        } while(inputView.readGameCommand().equals(GAME_COMMAND_QUIT));
    }
}
