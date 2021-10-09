package racinggame;

import static racinggame.Message.MESSAGE_VALIDATE_NAME;
import static racinggame.Message.formatErrorMessage;

public class RacingCar {
    private final String name;
    private int distance;

    public RacingCar(String source) {
        validateName(source);
        this.name = source;
        this.distance = 0;
    }

    private void validateName(String source) {
        if (source.length()>5){
            throw new IllegalArgumentException(formatErrorMessage(MESSAGE_VALIDATE_NAME));
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
