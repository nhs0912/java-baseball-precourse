package baseball.domain;

import java.util.List;

public class Referee {
    private Balls computerBalls;
    private Balls userBalls;
    private int strikeCount;
    private int ballCount;

    public Referee(Balls computerBalls, Balls userBalls) {
        this.computerBalls = computerBalls;
        this.userBalls = userBalls;
    }

    public Result checkResult() {
        initCount();
        return compareBall(computerBalls, userBalls);
    }

    private void initCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private Result compareBall(Balls computerBalls, Balls userBalls) {
        List<Ball> computerBallList = computerBalls.balls();
        List<Ball> userBallList = userBalls.balls();
        return compareComputerAndUserBalls(computerBallList, userBallList);
    }

    private Result compareComputerAndUserBalls(List<Ball> computerBallList, List<Ball> userBallList) {
        for (int computerIndex = 0; computerIndex < computerBallList.size(); computerIndex++) {
            Ball computerBall = computerBallList.get(computerIndex);
            searchSameNumber(userBallList, computerIndex, computerBall);
        }
        return new Result(strikeCount, ballCount);
    }

    private void searchSameNumber(List<Ball> userBallList, int computerIndex, Ball computerBall) {
        for (int userIndex = 0; userIndex < userBallList.size(); userIndex++) {
            Ball userBall = userBallList.get(userIndex);
            if (calculateStrikeAndBall(computerIndex, computerBall, userIndex, userBall)) {
                break;
            }
        }
    }

    private boolean calculateStrikeAndBall(int computerIndex, Ball computerBall, int userIndex, Ball userBall) {
        if (computerBall.number() == (userBall.number())) {
            return addCountStrikeAndBall(computerIndex, userIndex);
        }
        return false;
    }

    private boolean addCountStrikeAndBall(int computerIndex, int userIndex) {
        if (computerIndex == userIndex) {
            strikeCount++;
        }

        if (computerIndex != userIndex) {
            ballCount++;
        }
        return true;
    }

}
