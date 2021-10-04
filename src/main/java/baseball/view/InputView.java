package baseball.view;

import baseball.domain.Numeral;
import baseball.exception.MyErrorCode;
import baseball.exception.MyException;
import nextstep.utils.Console;

public class InputView {
    public String sayInputNumbers() {
        printMentionInputNumbers();
        return inputNumbers();
    }

    public String sayGameRestartOrQuit() {
        printMentionGameRestartOrQuit();
        return inputGameRestartOrQuit();
    }

    private void printMentionInputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private String inputNumbers() {
        return Console.readLine();
    }

    private void printMentionGameRestartOrQuit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    private String inputGameRestartOrQuit() {
        String inputGameRestart = Console.readLine();
        if (!validInputGameStart(inputGameRestart)) {
            throw new MyException(MyErrorCode.INVALID_INPUT_GAME_RESTART);
        }
        return inputGameRestart;
    }

    private boolean validInputGameStart(String inputGameRestart) {
        return inputGameRestart.equals(Numeral.ONE.numberText()) || inputGameRestart.equals(Numeral.TWO.numberText());
    }

}
