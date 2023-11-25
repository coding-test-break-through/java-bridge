package bridge.view.output;

import bridge.domain.dto.BridgeResultDto;

/**
 * - 제공된 `OutputView` 클래스를 활용해 구현해야 한다. - `OutputView`의 패키지는 변경할 수 있다. - `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에
 * 따라 추가하거나 변경할 수 있다. - 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void println() {
        System.out.println();
    }

    public void printMap(BridgeResultDto bridgeResultDto) {
        for (StringBuilder result : bridgeResultDto.result()) {
            System.out.println(result);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printMessage(Output output) {
        System.out.println(output.message);
    }

    public void printfMessage(Output output, Object... args) {
        System.out.printf(output.message, args);
    }
}
