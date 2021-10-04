package baseball.domain;

public class Ball {
    private Number number;

    public Ball(int number) {
        this(new Number(number));
    }

    public Ball(char number) {
        this(new Number(number - '0'));
    }

    public Ball(Number number) {
        this.number = number;
    }

    public int number() {
        return this.number.number();
    }
}
