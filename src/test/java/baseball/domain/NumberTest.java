package baseball.domain;

import baseball.exception.MyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumberTest {

    @Test
    @DisplayName("1~9사이의 Number가 생성되는지 테스트")
    void createNumberSuccess() {
        Number number = new Number(1);
        assertThat(number.Number()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    @DisplayName("1-9범위 밖의 숫자를 입력하였을 경우")
    void createNumberSuccess(int inputNumber) {
        assertThatExceptionOfType(MyException.class)
                .isThrownBy(() -> {
                    new Number(inputNumber);
                }).withMessageContaining("[ERROR] 숫자를 잘못 입력하였습니다. (1-9 숫자를 입력해야합니다.)");
    }
}
