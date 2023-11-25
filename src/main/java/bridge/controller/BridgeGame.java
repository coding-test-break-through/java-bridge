package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.dto.GameResultDto;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;
    private Bridge bridge;
    private int gameTryCount;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.player = new Player();
        gameTryCount = 1;
    }

    public void playGame() {
        outputView.printGameStart();
        boolean isRunning = true;
        int bridgeSize = getBridgeSize();
        this.bridge = Bridge.createBridge(bridgeSize);
        while (player.getPosition() < bridgeSize && isRunning) {
            isRunning = executeRound(isRunning);
        }
        if (isRunning) {
            outputView.printResult(new GameResultDto(bridge.getBridge(), player.getPlayerRoute(), "성공", gameTryCount));
        }
    }

    private boolean executeRound(boolean isRunning) {
        move();
        if (!player.checkBridge(bridge)) {
            isRunning = retry();
        }
        return isRunning;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String moving = getMoving();
        player.move(moving);
        outputView.printMap(bridge.getBridge(), player.getPlayerRoute());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String gameCommand = getGameCommand();
        if ("Q".equals(gameCommand)) {
            outputView.printResult(new GameResultDto(bridge.getBridge(), player.getPlayerRoute(), "실패", gameTryCount));
            return false;
        }
        player.goStart();
        gameTryCount++;
        return true;
    }

    private <T> T performInputOperation(InputOperation<T> operation) {
        do {
            try {
                return operation.operate();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (true);
    }

    private int getBridgeSize() {
        return performInputOperation(inputView::readBridgeSize);
    }

    private String getMoving() {
        return performInputOperation(inputView::readMoving);
    }

    private String getGameCommand() {
        return performInputOperation(inputView::readGameCommand);
    }

}
