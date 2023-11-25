package bridge.formatter;

import bridge.domain.dto.BridgeMapDto;
import bridge.domain.dto.BridgeResultDto;
import bridge.util.BridgeConstant;
import java.util.List;

public class OutputFormatter {
    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = "]";
    private static final String PASSABLE_SYMBOL = " O ";
    private static final String NOT_PASSABLE_SYMBOL = " X ";
    private static final Character NOT_PASSABLE_CHAR = 'X';
    private static final String SEPARATE_SYMBOL = "|";
    private static final String EMPTY_SYMBOL = "   ";
    private static final String FAIL = "실패";
    private static final String SUCCESS = "성공";

    public BridgeResultDto formatResult(List<BridgeMapDto> bridgeResults) {
        StringBuilder firstBridge = new StringBuilder(BRIDGE_START);
        StringBuilder secondBridge = new StringBuilder(BRIDGE_START);
        System.out.println(bridgeResults.toString());

        for (int index = 0; index < bridgeResults.size(); index++) {
            String firstResult = formatBridgeResult(bridgeResults.get(index), BridgeConstant.UP_BRIDGE_STATUS);
            String secondResult = formatBridgeResult(bridgeResults.get(index), BridgeConstant.DOWN_BRIDGE_STATUS);

            firstBridge.append(firstResult);
            secondBridge.append(secondResult);

            if (index + 1 == bridgeResults.size()) {
                firstBridge.append(BRIDGE_END);
                secondBridge.append(BRIDGE_END);
                break;
            }

            firstBridge.append(SEPARATE_SYMBOL);
            secondBridge.append(SEPARATE_SYMBOL);
        }

        List<StringBuilder> brideResult = List.of(firstBridge, secondBridge);
        return new BridgeResultDto(brideResult, validateBridgeNotSuccess(brideResult));
    }

    public String isSucceedGame(boolean isFalse) {
        if (isFalse) {
            return FAIL;
        }
        return SUCCESS;
    }

    private boolean selectedBridge(BridgeMapDto bridgeMapDto, String symbol) {
        return symbol.equals(bridgeMapDto.selectBridge());
    }

    private String formatBridgeResult(BridgeMapDto bridgeMapDto, String symbol) {
        if (selectedBridge(bridgeMapDto, symbol)) {
            if (bridgeMapDto.result()) {
                return PASSABLE_SYMBOL;
            }
            return NOT_PASSABLE_SYMBOL;
        }
        return EMPTY_SYMBOL;
    }

    public boolean validateBridgeNotSuccess(List<StringBuilder> bridgeMap) {
        return bridgeMap.stream()
                .flatMapToInt(CharSequence::chars)
                .anyMatch(c -> c == NOT_PASSABLE_CHAR);
    }
}
