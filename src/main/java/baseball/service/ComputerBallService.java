package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Numeral;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerBallService {
    public Balls makeBalls() {
        List<Ball> computerBallList = new ArrayList<>();
        Set<Integer> computerNumbers = createBallsWithoutDuplicateNumber();
        return saveBalls(computerBallList, computerNumbers);
    }

    private Balls saveBalls(List<Ball> computerBallList, Set<Integer> computerNumbers) {
        System.out.print("정답: ");
        for (Integer number : computerNumbers) {
            Ball newBall = new Ball(number);
            computerBallList.add(newBall);
            System.out.print(number);
        }
        System.out.println();
        return new Balls(computerBallList);
    }

    private Set<Integer> createBallsWithoutDuplicateNumber() {
        Set<Integer> computerNumbers = new HashSet<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(Numeral.ONE.number(), Numeral.NINE.number());
            computerNumbers.add(randomNumber);
        }
        return computerNumbers;
    }
}
