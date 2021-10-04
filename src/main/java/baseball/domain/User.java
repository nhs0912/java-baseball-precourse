package baseball.domain;

public class User {
    private Balls balls;

    public User(Balls balls) {
        this.balls = balls;
    }

    public Balls balls() {
        return this.balls;
    }

}
