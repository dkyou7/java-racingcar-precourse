package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingResult;
import racinggame.domain.Winner;

import static racinggame.Message.*;
import static racinggame.Rule.ZERO;

public class RacingView {

    private RacingCars racingCars;
    private Integer racingTime;

    public RacingCars userInputName() {
        System.out.print(MESSAGE_INPUT_NAME);
        String inputName = Console.readLine();
        try {
            this.racingCars = new RacingCars(inputName);
            return new RacingCars(inputName);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return userInputName();
        }
    }

    public RacingCars userInputTime() {
        System.out.print(MESSAGE_INPUT_TIME);
        String inputName = Console.readLine();
        try {
            this.racingTime = Integer.valueOf(inputName);
            return new RacingCars(inputName);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return userInputName();
        }
    }

    public void race() {
        System.out.println("실행 결과");
        for (int i = ZERO; i < racingTime; i++) {
            RacingResult racingResult = racingCars.race();
            racingResult.printResult();
        }
        Winner winner = new Winner(racingCars);
        winner.findWinnerName();
        System.out.println(String.format("최종 우승자는 %s 입니다.", winner.printWinners()));
    }
}
