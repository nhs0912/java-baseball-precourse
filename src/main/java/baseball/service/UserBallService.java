package baseball.service;

import baseball.domain.Balls;
import baseball.exception.MyException;

public class UserBallService {

    public Balls makeBalls(String numberText) throws MyException {
        return new Balls(numberText);
    }

}
