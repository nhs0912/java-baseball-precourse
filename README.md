# 숫자 야구 게임
## Model(Domain)
### Number
    1~9까지 범위를 체크한다.
* private int number
* private void checkLength()

### Ball
    숫자 데이터를 가진 공   
* private Number number

### Balls
    Ball 3개를 가지고 있어야한다.
* public void makeBalls()

### User
    입력 받은 Ball 3개를 가지고 있다.
* private Balls balls
* public Balls balls()

### Computer
    랜덤으로 가진 Ball 3개를 가지고 있다.
* private Balls balls
* public Balls balls() 

### Referee
    User와 Computer가 가지고 있는 Ball을 판단해서 스트라이크, 볼을 체크한다.
* private Computer computer
* private User user
* public Result checkResult()
* private int checkStrike()
* private int checkBall()

### Result
    strike and ball의 결과를 가지고 있다. 
* private int strike
* private int ball

### Game
    게임 시작과 종료, 다시 시작하는 기능을 가진다. 

## View
###InputView
    입력된 View를 보여준다.

###OutputView
    출력된 View를 보여준다.
