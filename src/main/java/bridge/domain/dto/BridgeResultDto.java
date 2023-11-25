package bridge.domain.dto;

import java.util.List;

public record BridgeResultDto(List<StringBuilder> result, boolean isEnds) {
}
