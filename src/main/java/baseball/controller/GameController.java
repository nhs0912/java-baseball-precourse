package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Numeral;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.exception.MyException;
import baseball.service.ComputerBallService;
import baseball.service.UserBallService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        ComputerBallService computerBallService = new ComputerBallService();
        Balls computerBalls = computerBallService.makeBalls();

        Result result = new Result();
        while (result.strikeCount() != Numeral.THREE.number()) {
            try {
                result = guessComputerBalls(computerBalls);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
            outputView.printGameResult(result.strikeCount(), result.ballCount());
        }
    }

    private Result guessComputerBalls(Balls computerBalls) {
        Balls userBalls = makeUserBalls();
        return calculateResult(computerBalls, userBalls);
    }

    private Result calculateResult(Balls computerBalls, Balls userBalls) {
        Referee referee = new Referee(computerBalls, userBalls);
        return referee.checkResult();
    }

    private Balls makeUserBalls() {
        String inputNumbers = inputView.sayInputNumbers();
        UserBallService userBallService = new UserBallService();
        Balls userBalls = userBallService.makeBalls(inputNumbers);
        return userBalls;
    }
}
