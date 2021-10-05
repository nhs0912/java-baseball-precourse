package baseball;

import baseball.domain.Balls;
import baseball.domain.Numeral;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.exception.MyException;
import baseball.service.ComputerBallService;
import baseball.service.UserBallService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    private static InputView inputView;
    private static OutputView outputView;

    public static void main(String[] args) {
        inputView = new InputView();
        outputView = new OutputView();
        String gameRestart;
        ComputerBallService computerBallService = new ComputerBallService();

        do {
            Balls computerBalls = computerBallService.makeBalls();
            solveNumberGame(computerBalls);
            gameRestart = repeatInputGameRestart();
        } while (isReGame(gameRestart));
    }

    private static void solveNumberGame(Balls computerBalls) {
        Result result = new Result();
        while (result.strikeCount() != Numeral.THREE.number()) {
            Balls userBalls = makeUserBalls(inputView);
            result = calculateResult(computerBalls, userBalls);
            outputView.printGameResult(result.strikeCount(), result.ballCount());
        }
    }

    private static Balls makeUserBalls(InputView inputView) {
        Balls userBalls = new Balls();
        UserBallService userBallService = new UserBallService();
        while (isOut(userBalls)) {
            String numberText = inputView.sayInputNumbers();
            userBalls = userBallService.makeBalls(numberText, userBalls);
        }
        return userBalls;
    }

    private static boolean isOut(Balls userBalls) {
        return userBalls.size() != Numeral.THREE.number();
    }

    private static Result calculateResult(Balls computerBalls, Balls userBalls) {
        Referee referee = new Referee(computerBalls, userBalls);
        return referee.checkResult();
    }

    private static String repeatInputGameRestart() {
        String gameRestart;
        do {
            gameRestart = inputGameRestartText();
        } while (!validInputGameStart(gameRestart));
        return gameRestart;
    }

    private static String inputGameRestartText() {
        try {
            return inputView.sayGameRestartOrQuit();
        } catch (MyException e) {
            System.out.println(e.getMessage());
            return Numeral.ZERO.numberText();
        }
    }

    private static boolean isReGame(String gameRestart) {
        return gameRestart.equals(Numeral.ONE.numberText());
    }

    private static boolean validInputGameStart(String inputGameRestart) {
        return inputGameRestart.equals(Numeral.ONE.numberText()) || inputGameRestart.equals(Numeral.TWO.numberText());
    }
}
