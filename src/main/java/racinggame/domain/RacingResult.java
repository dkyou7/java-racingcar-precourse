package racinggame.domain;

import java.util.ArrayList;

import static racinggame.Rule.ZERO;

public class RacingResult {

    private final ArrayList<RacingCar> racingCars;

    public RacingResult(ArrayList<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }


    public void printResult() {
        for (int i = ZERO; i < racingCars.size(); i++) {
            System.out.println(racingCars.get(i).toString());
        }
        System.out.println();
    }

}
