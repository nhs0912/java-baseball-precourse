package baseball.controller;

import baseball.domain.*;
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
        while (!isThreeStrike(result)) {
            try {
                Balls userBalls = makeUserBalls();
                result = calculateResult(computerBalls, userBalls);
                outputView.printGameResult(result.strikeCount(), result.ballCount());
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Result calculateResult(Balls computerBalls, Balls userBalls) {
        Referee referee = new Referee(computerBalls, userBalls);
        return referee.checkResult();
    }

    private Balls makeUserBalls() {
        String inputNumbers = inputView.sayInputNumbers();
        UserBallService userBallService = new UserBallService();
        return userBallService.makeBalls(inputNumbers);
    }

    private boolean isThreeStrike(Result result) {
        return result.strikeCount() == Numeral.THREE.number();
    }
}
