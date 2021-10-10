package racinggame.domain;

import java.util.ArrayList;

public class RacingResult {

    private final ArrayList<RacingCar> racingCars;

    public RacingResult(ArrayList<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }


    public void printResult() {
        for (int i = 0; i < racingCars.size(); i++) {
            System.out.println(racingCars.get(i).toString());
        }
        System.out.println();
    }

}
