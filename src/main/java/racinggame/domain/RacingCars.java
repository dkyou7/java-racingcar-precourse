package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;

import static racinggame.Rule.*;

public class RacingCars {

    private ArrayList<RacingCar> racingCars;

    public RacingCars(String carString) {
        this.racingCars = getRacingCars(carString);
    }

    private ArrayList<RacingCar> getRacingCars(String carString) {
        String[] split_string = carString.split(SPLIT_VALUE);
        ArrayList<RacingCar> res = new ArrayList<>();
        for (int i = ZERO; i < split_string.length; i++) {
            res.add(new RacingCar(split_string[i]));
        }
        return res;
    }


    public int getSize() {
        return this.racingCars.size();
    }

    public ArrayList<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public RacingResult race() {
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).race(Randoms.pickNumberInRange(RULE_MIN_VALUE, RULE_MAX_VALUE));
        }
        return new RacingResult(racingCars);
    }


}
