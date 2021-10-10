package racinggame.domain;

import static racinggame.Message.MESSAGE_VALIDATE_NAME;
import static racinggame.Message.MESSAGE_VALIDATE_MIN_LENGTH;
import static racinggame.Message.formatErrorMessage;
import static racinggame.Rule.ZERO;
import static racinggame.Rule.RULE_LIMIT_NAME;
import static racinggame.Rule.RULE_MOVE_SPEED;

public class RacingCar implements Comparable<RacingCar>{
    private final String name;
    private String distance_view;

    public RacingCar(String source) {
        validateName(source);
        this.name = source;
        this.distance_view = "";
    }

    private void validateName(String source) {
        if (source.length()== ZERO){
            throw new IllegalArgumentException(formatErrorMessage(MESSAGE_VALIDATE_MIN_LENGTH));
        }
        if (source.length()> RULE_LIMIT_NAME){
            throw new IllegalArgumentException(formatErrorMessage(MESSAGE_VALIDATE_NAME));
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance_view.length();
    }

    public void race(int speed) {
        if (isMovable(speed)){
            distance_view += "-";
        }
    }

    public boolean isMovable(int speed){
        return speed >= RULE_MOVE_SPEED;
    }

    @Override
    public String toString() {
        return String.format("%s : %s",name,distance_view);
    }

    @Override
    public int compareTo(RacingCar o) {
        return o.getDistance() - getDistance();
    }
}
