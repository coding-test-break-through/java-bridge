package bridge.dto;

import java.util.List;

public class GameResultDto {
    List<String> bridge;
    List<String> playerRoute;
    String gameResultMessage;
    int gameTryCount;

    public GameResultDto(List<String> bridge, List<String> playerRoute, String gameResultMessage, int gameTryCount) {
        this.bridge = bridge;
        this.playerRoute = playerRoute;
        this.gameResultMessage = gameResultMessage;
        this.gameTryCount = gameTryCount;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getPlayerRoute() {
        return playerRoute;
    }

    public String getGameResultMessage() {
        return gameResultMessage;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }
}
