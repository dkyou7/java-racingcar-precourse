package racinggame;

import static racinggame.Message.*;

public class RacingCar implements Comparable<RacingCar>{
    private final String name;
    private String distance_view;

    public RacingCar(String source) {
        validateName(source);
        this.name = source;
        this.distance_view = "";
    }

    private void validateName(String source) {
        if (source.length()==0){
            throw new IllegalArgumentException(formatErrorMessage(MESSAGE_VALIDATE_MIN_LENGTH));
        }
        if (source.length()>5){
            throw new IllegalArgumentException(formatErrorMessage(MESSAGE_VALIDATE_NAME));
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance_view.length();
    }

    public int race(int speed) {
        if (isMovable(speed)){
            distance_view += "-";
        }
        return distance_view.length();
    }

    public boolean isMovable(int speed){
        return speed >= 4;
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
