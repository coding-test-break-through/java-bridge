package bridge.domain;

import java.util.List;

public class Player {
    private final PlayerRoute playerRoute;
    private int position;

    public Player() {
        this.playerRoute = PlayerRoute.createPlayerRoute();
        this.position = 0;
    }

    public void move(String moving) {
        position++;
        playerRoute.add(moving);
    }

    public List<String> getPlayerRoute() {
        return playerRoute.getRoute();
    }

    public int getPosition() {
        return position;
    }

    public boolean checkBridge(Bridge bridge) {
        String now = playerRoute.get(position - 1);
        return now.equals(bridge.get(position - 1));
    }

    public void goStart() {
        position = 0;
        playerRoute.clear();
    }
}
