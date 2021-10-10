package racinggame.controller;

import racinggame.view.RacingView;

public class GameController {
    public void start() {
        RacingView racingView = new RacingView();
        racingView.userInputName();
        racingView.userInputTime();
        racingView.race();
    }
}
