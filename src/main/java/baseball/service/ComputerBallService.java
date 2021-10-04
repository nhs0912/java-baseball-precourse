package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Numeral;
import nextstep.utils.Randoms;

import java.util.*;

public class ComputerBallService {
    public Balls makeBalls() {
        List<Ball> computerBallList = new ArrayList<>();
        Set<Integer> computerNumbers = createBallsWithoutDuplicateNumber();
        return saveBalls(computerBallList, computerNumbers);
    }

    private Set<Integer> createBallsWithoutDuplicateNumber() {
        Set<Integer> computerNumbers = new LinkedHashSet<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(Numeral.ONE.number(), Numeral.NINE.number());
            computerNumbers.add(randomNumber);
        }
        return computerNumbers;
    }

    private Balls saveBalls(List<Ball> computerBallList, Set<Integer> computerNumbers) {
        for (Integer number : computerNumbers) {
            Ball newBall = new Ball(number);
            computerBallList.add(newBall);
        }
        return new Balls(computerBallList);
    }
}
