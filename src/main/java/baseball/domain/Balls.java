package baseball.domain;

import baseball.exception.MyErrorCode;
import baseball.exception.MyException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private List<Ball> ballList;

    public Balls(List<Ball> ballList) {
        validInputValue(ballList);
        this.ballList = ballList;
    }

    public List<Ball> balls(){
        return this.ballList;
    }

    private void validInputValue(List<Ball> ballList){
        validSizeOfBalls(ballList);
        checkDuplicateNumber(ballList);
    }

    private void validSizeOfBalls(List<Ball> ballList) {
        if (checkNotThreeCountOfBalls(ballList)) {
            throw new MyException(MyErrorCode.INVALID_THREE_COUNT_OF_BALL);
        }
    }

    private boolean checkNotThreeCountOfBalls(List<Ball> ballList) {
        return Numeral.THREE.number() != ballList.size();
    }

    private boolean checkNotThreeCountOfBalls(Set<Integer> ballNumbers) {
        return Numeral.THREE.number() != ballNumbers.size();
    }

    private void checkDuplicateNumber(List<Ball> ballList){
        Set<Integer> ballNumbers = new HashSet<>();
        for (Ball ball : ballList) {
            ballNumbers.add(ball.number());
        }

        if (checkNotThreeCountOfBalls(ballNumbers)) {
            throw new MyException(MyErrorCode.BALL_HAS_DUPLICATE_NUMBER);
        }
    }

}
