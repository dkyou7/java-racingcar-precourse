package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racinggame.Rule.ZERO;

public class Winner {
    private final RacingCars racingCars;
    private final int findMaxLen;
    private List<String> winnerName;

    public Winner(RacingCars racingCars) {
        Collections.sort(racingCars.getRacingCars());
        this.findMaxLen = racingCars.getRacingCars().get(ZERO).getDistance();
        this.racingCars = racingCars;
    }

    public void findWinnerName() {
        List<String> res = new ArrayList<>();
        for (int i = ZERO; i < racingCars.getSize(); i++) {
            extractedWinner(res, i);
        }
        this.winnerName = res;
    }

    private void extractedWinner(List<String> res, int i) {
        if(findMaxLen == racingCars.getRacingCars().get(i).getDistance()){
            res.add(racingCars.getRacingCars().get(i).getName());
        }
    }

    public String printWinners() {
        return String.join(",",winnerName);
    }
}
