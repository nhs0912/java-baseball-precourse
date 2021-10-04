package baseball.view;

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
        return Console.readLine();
    }

}
