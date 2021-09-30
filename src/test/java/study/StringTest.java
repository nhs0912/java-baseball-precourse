package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("1,2가 잘 분리 되는지 확인하는 테스트")
    public void divideTest(){
        String inputText = "1,2";
        String[] resultTexts = inputText.split(",");
        Assertions.assertThat(resultTexts).contains("1","2");
    }
}
