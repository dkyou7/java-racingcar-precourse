package racinggame;

import jdk.internal.jimage.ImageReader;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private ArrayList<RacingCar> racingCar;

    public RacingCars(String test) {
        String[] split = test.split(",");
        ArrayList<RacingCar> res = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            res.add(new RacingCar(split[i]));
        }
        this.racingCar = res;
    }

    public int getSize() {
        return this.racingCar.size();
    }

    public ArrayList<RacingCar> getCars() {
        return this.racingCar;
    }
}
