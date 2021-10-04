package baseball.domain;

public class Computer {
    private Balls balls;

    public Computer(Balls balls) {
        this.balls = balls;
    }

    public Balls balls() {
        return this.balls;
    }
}
