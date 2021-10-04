package baseball.domain;

import baseball.exception.MyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class BallsTest {

    private Number one = new Number(1);
    private Number two = new Number(2);
    private Number three = new Number(3);
    private Number four = new Number(4);

    @Test
    @DisplayName("balls의 개수가 3개일 경우")
    void checkThreeBalls() {
        List<Ball> ballList = Arrays.asList(new Ball(one), new Ball(two), new Ball(three));
        Balls balls = new Balls(ballList);
        assertThat(balls.balls().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("balls의 개수가 3개 넘을 경우")
    void checkOverThreeBalls() {
        List<Ball> ballList = Arrays.asList(new Ball(one), new Ball(two), new Ball(three), new Ball(four));
        assertThatExceptionOfType(MyException.class)
                .isThrownBy(() -> {
                    new Balls(ballList);
                }).withMessageContaining("[ERROR] 볼의 개수는 3개를 입력해야합니다.");
    }

    @Test
    @DisplayName("balls의 개수가 1개일 경우")
    void checkLessThreeBalls() {
        List<Ball> ballList = Arrays.asList(new Ball(one));
        assertThatExceptionOfType(MyException.class)
                .isThrownBy(() -> {
                    new Balls(ballList);
                }).withMessageContaining("[ERROR] 볼의 개수는 3개를 입력해야합니다.");
    }

    @Test
    @DisplayName("balls에서 중복된 숫자가 있을 경우")
    void checkDuplicateThreeBalls() {
        List<Ball> ballList = Arrays.asList(new Ball(one), new Ball(two), new Ball(one));
        assertThatExceptionOfType(MyException.class)
                .isThrownBy(() -> {
                    new Balls(ballList);
                }).withMessageContaining("[ERROR] 중복된 숫자를 입력하였습니다.");
    }
}
