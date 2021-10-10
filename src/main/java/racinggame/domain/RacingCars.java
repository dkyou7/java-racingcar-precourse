package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;

public class RacingCars {

    private ArrayList<RacingCar> racingCars;

    public RacingCars(String carString) {
        this.racingCars = getRacingCars(carString);
    }

    private ArrayList<RacingCar> getRacingCars(String carString) {
        String[] split_string = carString.split(",");
        ArrayList<RacingCar> res = new ArrayList<>();
        for (int i = 0; i < split_string.length; i++) {
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
            int race = racingCars.get(i).race(Randoms.pickNumberInRange(0, 9));
        }
        return new RacingResult(racingCars);
    }


}
