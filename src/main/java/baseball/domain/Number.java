package baseball.domain;

import baseball.exception.MyErrorCode;
import baseball.exception.MyException;

public class Number {

    private int number;

    public Number(int number) {
        checkNumberLength(number);
        this.number = number;
    }

    public int Number(){
        return this.number;
    }

    private void checkNumberLength(int number) {
        if (isBetweenOneAndNine(number)) {
            throw new MyException(MyErrorCode.INVALID_NUMBER);
        }
    }

    private boolean isBetweenOneAndNine(int number) {
        return number < Numeral.ONE.number() || number > Numeral.NINE.number();
    }

}
