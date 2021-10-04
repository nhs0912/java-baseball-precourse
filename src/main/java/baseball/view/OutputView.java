package baseball.view;

import baseball.domain.Numeral;

public class OutputView {
    public void printGameResult(int strikeCount, int ballCount) {
        printCheckStrikeAndBall(strikeCount, ballCount);
        if (strikeCount == Numeral.THREE.number()) {
            printThreeStrike();
        }
    }

    private void printCheckStrikeAndBall(int strikeCount, int ballCount) {
        if (strikeCount > Numeral.ZERO.number()) {
            System.out.print(strikeCount + "스트라이크 ");
        }
        if (ballCount > Numeral.ZERO.number()) {
            System.out.print(ballCount + "볼");
        }
        System.out.println();
    }

    private void printThreeStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
