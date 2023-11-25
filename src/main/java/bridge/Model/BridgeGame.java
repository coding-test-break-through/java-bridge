package bridge.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BridgeGame {
    private List<String> bridgeMap;
    private Map<String, Boolean> resultMap;
    private Integer retryNum;

    public BridgeGame(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
        this.resultMap = new LinkedHashMap<>();
    }

    public boolean move(String userInput) {
        int currentRound = resultMap.size();
        if (currentRound < bridgeMap.size()) {
            boolean isCorrect = userInput.equals(bridgeMap.get(currentRound));
            resultMap.put(bridgeMap.get(currentRound), isCorrect);
            return true;
        }
        return false;
    }

    public void retry() {
        retryNum ++;
        resultMap.clear();
    }

    public Map<String, Boolean> getResultMap() {
        return resultMap;
    }

    public List<String> getBridgeMap() {
        return bridgeMap;
    }

    public int getRetryNum() {
        return retryNum;
    }
}
