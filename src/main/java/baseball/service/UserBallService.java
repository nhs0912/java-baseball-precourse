package baseball.service;

import baseball.domain.Balls;
import baseball.exception.MyException;

public class UserBallService {

    public Balls makeBalls(String numberText) {
        Balls userBalls = new Balls();
        try {
            userBalls = new Balls(numberText);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return userBalls;
    }

}
