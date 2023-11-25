package bridge.Model;

import static bridge.Constants.DomainConstants.MOVE_DIRECTION_DOWN;
import static bridge.Constants.DomainConstants.MOVE_DIRECTION_UP;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> generateBridgeElement())
                .collect(Collectors.toList());
    }

    private String generateBridgeElement() {
        if (bridgeNumberGenerator.generate() == 0) {
            return MOVE_DIRECTION_DOWN;
        }
        return MOVE_DIRECTION_UP;
    }
}