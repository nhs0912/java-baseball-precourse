package baseball.domain;

public class Ball {
    private Number number;

    public Ball(Number number) {
        this.number = number;
    }

    public int number() {
        return this.number.number();
    }
}
