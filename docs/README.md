### 입력
- 다리 길이
  - 다리의 길이를 숫자로 입력 받는다.
  - 유효성 검증을 실시한다.
    - 빈칸은 아닌지 확인한다
    - 공백은 없는지 확인한다
    - 입력이 숫자인지 확인한다 (정규표현식 사용)
    - 길이는 3이상 20 이하이다
    - 올바른 값이 아니면 예외 처리한다
      - `IllegalArgumentException`을 사용한다
      - 에러 문구는 "[ERROR]"로 시작해야 한다.
    - 올바르지 않는 입력을 받는 경우 다시 입력을 받는다

- 플레이어가 이동할 칸
  - 라운드마다 이동할 칸을 입력 받는다
  - 위 칸 이동 희망의 경우 대문자 U, 아래 칸의 경우 대문자 D를 받는다
  - U와 D가 아닌 경우 예외처리한다
      - `IllegalArgumentException`을 사용한다
      - 에러 문구는 "[ERROR]"로 시작해야 한다.
  - 올바르지 않는 입력을 받는 경우 다시 입력을 받는다  

- 게임 재시작/종료 여부 입력을 받는다
  - 재시작을 원할 경우 R, 종료하고 싶을 경우 Q
  - 올바른 값이 아닐 경우 예외처리
    - `IllegalArgumentException`을 사용한다
    - 에러 문구는 "[ERROR]"로 시작해야 한다.
  - 올바르지 않는 입력을 받는 경우 다시 입력을 받는다



### 출력
- 게임 시작 문구
  - "다리 건너기 게임을 시작합니다."

- 매 라운드 건너기 시도 문구
  - "이동할 칸을 선택해주세요. (위: U, 아래: D)"

- 최종 게임 결과
  - 플레이어가 이동한 칸을 시각화한다. 
    - `OutputView`클래스의 `printMap()` 메서드 안에 구현한다
      - 이동할 수 있는 칸의 경우 O, 없는 칸의 경우 X
      - 선택하지 않은 칸은 공백 한 칸으로 표시
      - 다리의 시작은 \[, 다리의 끝은 ]으로 표시
      - 다리 칸의 구분은 | (앞뒤 공백 포함) 문자열로 구분
- 
- 게임 재시작 여부 문구
    - "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

- 게임 결과를 출력한다
  - `OutputView`클래스의 `printResult()` 메서드 안에 구현한다
      - 게임 결과 입력에서 사용자가 Q를 눌렀을 경우 (재시작 하지 않을 경우) 출력한다
        - "게임 성공 여부: 성공 or 실패"
        - "총 시도한 횟수: N"


### 상수값
#### InputViewPrompt
- 다리 건너기 게임을 시작합니다.
- 다리의 길이를 입력해주세요.
- 이동할 칸을 선택해주세요. 
- 게임을 다시 시도할지 여부를 입력해주세요.
- ,
- ( )

#### Domain
- 위칸: U
- 아래칸: D
- 재시도: R
- 종료: Q
- 맵 프린트 시작: [
- 맵 프린트 종료: ]
- 맵 구분: |
- 맵 이동 성공: O
- 맵 이동 실패: X
- 위:
- 아래:
- 재시도:
- 종료:
- 성공
- 실패

#### OutputViewPrompt
- 최종 게임 결과
- 게임 성공 여부:
- 총 시도한 횟수:




### Model
- BridgeGame 클래스
  - 기본
      - 필드(인스턴스 변수) 추가 가능, 패키지 변경 가능, 인자와 반환 타입 변경 가능
      - 필요한 메서드를 추가하거나 변경 가능
      - 메서드 이름 변경 불가능
        ```java
        public class BridgeGame {
      
            public void move() {
            }
      
            public void retry() {
            }
        }
        ```
  - BridgeGame 인스턴스를 만들고 그 하나를 재사용하면서 쓰게 만든다
  - 

- BridgeMaker 클래스
    - 필드(인스턴스 변수) 추가, 변경 가능
    - 메서드의 시그니처(인자, 이름)과 반환 타입은 변경 불가능
      ```java
      public class BridgeMaker {
      
          public List<String> makeBridge(int size) {
              return null;
          }
      }
      ```
      - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
      - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다. 
      - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - BridgeRandomNumberGenerator 클래스를 이용한다
        - Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용
        - 0 혹은 1을 추출하는 클래스
          - 0이 아래 칸, 1이 위칸
        - 클래스의 코드는 변경 불가


### 요구조건
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- JUnit 5와 AssertJ를 이용하여 테스트 코드로 확인한다.
- else 예약어를 쓰지 않는다.
    - switch/case도 허용하지 않는다.
- 도메인 로직에 단위 테스트를 구현
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 주어진 InputView 클래스를 구현해서 사용한다 (변경해도 괜춘)
    ```java
    public class InputView {
    
        public int readBridgeSize() {
            return 0;
        }
    
        public String readMoving() {
            return null;
        }
    
        public String readGameCommand() {
            return null;
        }
    }
    ```
- OutputView 클래스
  - 패키지명만 변경 가능하고, 메서드 이름은 변경 불가. 인자와 반환 타입은 필요에 의해 추가 변경 가능
  - 메서드 추가 가능
    ```java
    public class OutputView {
    
        public void printMap() {
        }
    
        public void printResult() {
        }
    }
    ```

- BridgeGame 클래스
  - 필드(인스턴스 변수) 추가 가능, 패키지 변경 가능, 인자와 반환 타입 변경 가능
  - 필요한 메서드를 추가하거나 변경 가능
  - 메서드 이름 변경 불가능
    ```java
    public class BridgeGame {
    
        public void move() {
        }
    
        public void retry() {
        }
    }
    ```

- BridgeMaker 클래스
  - 필드(인스턴스 변수) 추가, 변경 가능
  - 메서드의 시그니처(인자, 이름)과 반환 타입은 변경 불가능
    ```java
    public class BridgeMaker {
    
        public List<String> makeBridge(int size) {
            return null;
        }
    }
    ```

- BridgeRandomNumberGenerator 클래스
  - Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용
  - 클래스의 코드는 변경 불가
  - 