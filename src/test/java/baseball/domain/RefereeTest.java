package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RefereeTest {

    private Number one = new Number(1);
    private Number two = new Number(2);
    private Number three = new Number(3);
    private Number four = new Number(4);
    private Number five = new Number(5);
    private Number six = new Number(6);

    @Test
    @DisplayName("2 스트라이크 결과를 구하는 테스트")
    void checkTwoStrikeResult() {
        List<Ball> userBallList = Arrays.asList(new Ball(one), new Ball(two), new Ball(three));
        Balls userBalls = new Balls(userBallList);
        User user = new User(userBalls);

        List<Ball> computerBallList = Arrays.asList(new Ball(one), new Ball(four), new Ball(three));
        Balls computerBalls = new Balls(computerBallList);
        Computer computer = new Computer(computerBalls);

        Referee referee = new Referee(computer, user);
        Result result = referee.checkResult();

        assertAll(
                () -> assertThat(result.strikeCount()).isEqualTo(2),
                () -> assertThat(result.ballCount()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("1 스트라이크 1ball 결과를 구하는 테스트")
    void checkOneStrikeOneBallResult() {
        List<Ball> userBallList = Arrays.asList(new Ball(one), new Ball(two), new Ball(three));
        Balls userBalls = new Balls(userBallList);
        User user = new User(userBalls);

        List<Ball> computerBallList = Arrays.asList(new Ball(one), new Ball(four), new Ball(two));
        Balls computerBalls = new Balls(computerBallList);
        Computer computer = new Computer(computerBalls);

        Referee referee = new Referee(computer, user);
        Result result = referee.checkResult();

        assertAll(
                () -> assertThat(result.strikeCount()).isEqualTo(1),
                () -> assertThat(result.ballCount()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("0 스트라이크 3ball 결과를 구하는 테스트")
    void checkZeroStrikeThreeBallResult() {
        List<Ball> userBallList = Arrays.asList(new Ball(three), new Ball(two), new Ball(one));
        Balls userBalls = new Balls(userBallList);
        User user = new User(userBalls);

        List<Ball> computerBallList = Arrays.asList(new Ball(one), new Ball(three), new Ball(two));
        Balls computerBalls = new Balls(computerBallList);
        Computer computer = new Computer(computerBalls);

        Referee referee = new Referee(computer, user);
        Result result = referee.checkResult();

        assertAll(
                () -> assertThat(result.strikeCount()).isEqualTo(0),
                () -> assertThat(result.ballCount()).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("3 스트라이크 0 ball 결과를 구하는 테스트")
    void checkThreeStrikeZeroBallResult() {
        List<Ball> userBallList = Arrays.asList(new Ball(one), new Ball(two), new Ball(three));
        Balls userBalls = new Balls(userBallList);
        User user = new User(userBalls);

        List<Ball> computerBallList = Arrays.asList(new Ball(one), new Ball(two), new Ball(three));
        Balls computerBalls = new Balls(computerBallList);
        Computer computer = new Computer(computerBalls);

        Referee referee = new Referee(computer, user);
        Result result = referee.checkResult();

        assertAll(
                () -> assertThat(result.strikeCount()).isEqualTo(3),
                () -> assertThat(result.ballCount()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("0 스트라이크 0 ball 결과를 구하는 테스트")
    void checkZeroStrikeZeroBallResult() {
        List<Ball> userBallList = Arrays.asList(new Ball(one), new Ball(two), new Ball(three));
        Balls userBalls = new Balls(userBallList);
        User user = new User(userBalls);

        List<Ball> computerBallList = Arrays.asList(new Ball(four), new Ball(five), new Ball(six));
        Balls computerBalls = new Balls(computerBallList);
        Computer computer = new Computer(computerBalls);

        Referee referee = new Referee(computer, user);
        Result result = referee.checkResult();

        assertAll(
                () -> assertThat(result.strikeCount()).isEqualTo(0),
                () -> assertThat(result.ballCount()).isEqualTo(0)
        );
    }


}
