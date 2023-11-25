package bridge.domain;

import bridge.domain.dto.BridgeMapDto;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final List<String> passableBridge;

    private BridgeGame(BridgeMaker bridgeMaker, List<String> passableBridge) {
        this.bridgeMaker = bridgeMaker;
        this.passableBridge = passableBridge;
    }

    public static BridgeGame playOf(final BridgeMaker bridgeMaker, final int size) {
        return new BridgeGame(bridgeMaker, bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMapDto move(String selectBridge, int tryCount) {
        boolean isPassable = isSelectedPassableBridge(tryCount, selectBridge);

        return new BridgeMapDto(isPassable, selectBridge);
    }

    private boolean isSelectedPassableBridge(int index, String selectBridge) {
        return passableBridge.get(index).equals(selectBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

}
