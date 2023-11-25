package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    public String get(int position) {
        return bridge.get(position);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
