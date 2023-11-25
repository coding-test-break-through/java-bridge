package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerRoute {
    private final List<String> route;

    private PlayerRoute(List<String> route) {
        this.route = route;
    }

    public static PlayerRoute createPlayerRoute() {
        return new PlayerRoute(new ArrayList<>());
    }

    public void add(String moving) {
        route.add(moving);
    }

    public String get(int position) {
        return route.get(position);
    }

    public List<String> getRoute() {
        return route;
    }

    public void clear() {
        route.clear();
    }
}
