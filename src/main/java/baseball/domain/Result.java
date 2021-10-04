package baseball.domain;

public class Result {
    private int strikeCount;
    private int ballCount;

    public Result() {
        this(0, 0);
    }

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int strikeCount() {
        return this.strikeCount;
    }

    public int ballCount() {
        return this.ballCount;
    }

}
