package baseball.view;

public class OutputView {
    private static final int THREE = 3;
    private static final int ZERO = 0;

    public void printGameResult(int strikeCount, int ballCount) {
        printCheckStrikeAndBall(strikeCount, ballCount);
        if (strikeCount == THREE) {
            printThreeStrike();
        }
    }

    private void printCheckStrikeAndBall(int strikeCount, int ballCount) {
        if (strikeCount > ZERO) {
            System.out.print(strikeCount + "스트라이크 ");
        }
        if (ballCount > ZERO) {
            System.out.print(ballCount + "볼");
        }
        System.out.println();
    }

    private void printThreeStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
