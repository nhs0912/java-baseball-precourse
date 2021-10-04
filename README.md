# 숫자 야구 게임
## Model(Domain)
### Number
    1~9까지 범위를 체크한다.
* private int number
* private void checkNumberLength(int number)
* private boolean isBetweenOneAndNine(int number)

### Ball
    숫자 데이터를 가진 공   
* private Number number
* public int number()

### Balls
    Ball 3개를 가지고 있어야한다.
* public List<Ball> balls()
* public int size()
* private void validInputValue(List<Ball> ballList)
* private void validSizeOfBalls(List<Ball> ballList)
* private boolean checkNotThreeCountOfBalls(List<Ball> ballList)
* private boolean checkNotThreeCountOfBalls(Set<Integer> ballNumbers)
* private void checkDuplicateNumber(List<Ball> ballList)
* private List<Ball> makeThreeBalls(String numberText)

### Referee
    User와 Computer가 가지고 있는 Ball을 판단해서 스트라이크, 볼을 체크한다.
* private Balls computerBalls
* private Balls userBalls
* private void initCount()
* private Result compareBall(Balls computerBalls, Balls userBalls)
* private Result compareComputerAndUserBalls(List<Ball> computerBallList, List<Ball> userBallList)
* private void searchSameNumber(List<Ball> userBallList, int computerIndex, Ball computerBall)

### Result
    strike and ball의 결과를 가지고 있다. 
* private int strike
* private int ball
* public int strikeCount()
* public int ballCount()

## View
### InputView
    입력된 View를 보여준다.
* public String sayInputNumbers()
* public String sayGameRestartOrQuit()
* private void printMentionInputNumbers()
* private String inputNumbers()
* private void printMentionGameRestartOrQuit()
* private String inputGameRestartOrQuit()
* private boolean validInputGameStart(String inputGameRestart)

### OutputView
    출력된 View를 보여준다.
* public void printGameResult(int strikeCount, int ballCount)
* private void printCheckStrikeAndBall(int strikeCount, int ballCount)
* private void printThreeStrike()

## Service
### ComputerBallService
    컴퓨터의 3개 볼을 만든다. 
* public Balls makeBalls()
* private Set<Integer> createBallsWithoutDuplicateNumber()
* private Balls saveBalls(List<Ball> computerBallList, Set<Integer> computerNumbers)
### UserBallService
    User의 3개 볼을 만든다. 
* public Balls makeBalls(String numberText, Balls userBalls) 

## Exception

### MyErrorCode
    에러메시지를 정의한다.
* public String errorMessage()
