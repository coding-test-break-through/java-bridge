package bridge;

import static bridge.Constants.DomainConstants.FINAL_GAME_CLEAR;
import static bridge.Constants.DomainConstants.GAME_COMMAND_RETRY;

import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.View.InputView.InputView;
import bridge.View.OutputView.OutputView;
import java.util.List;

public class Controller {

    private Integer bridgeSize;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    public void gameProcess(){
        bridgeSize = inputView.readBridgeSize();
        List<String> bridgeMap = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        playGame(bridgeGame);
        outputView.printResult(bridgeGame);
    }


    private void playGame(BridgeGame bridgeGame){
        do {
            bridgeGame.retry();
            continueOneRound(bridgeGame);
            if(bridgeGame.isGameClear()){
                break;
            }
        } while(inputView.readGameCommand().equals(GAME_COMMAND_RETRY));
    }

    private void continueOneRound(BridgeGame bridgeGame) {
        boolean playerAlive = true;
        do {
            if(bridgeGame.isGameClear()){
                break;
            }
            String moveDir = inputView.readMoving();
            playerAlive = bridgeGame.move(moveDir);
            outputView.printMap(bridgeGame);
        } while(playerAlive);
    }
}
