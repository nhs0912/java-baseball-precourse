package baseball;

import baseball.controller.GameController;
import baseball.domain.Numeral;
import baseball.exception.MyException;
import baseball.view.InputView;

public class Application {
    private static final String INIT_REGAME_VALUE = Numeral.ONE.numberText();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String regameText = INIT_REGAME_VALUE;

        while (isReGame(regameText)) {
            regameText = startGame(inputView, regameText);
        }
    }

    private static String startGame(InputView inputView, String regameText) {
        try {
            GameController gameController = new GameController();
            gameController.start();
            regameText = inputView.sayGameRestartOrQuit();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return regameText;
    }

    private static boolean isReGame(String gameRestart) {
        return gameRestart.equals(Numeral.ONE.numberText());
    }

    private static boolean validInputGameStart(String inputGameRestart) {
        return inputGameRestart.equals(Numeral.ONE.numberText()) || inputGameRestart.equals(Numeral.TWO.numberText());
    }
}
