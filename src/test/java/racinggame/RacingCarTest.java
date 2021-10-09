package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void createManyCarTest(){
        RacingCars racingCars = new RacingCars("test1,test2");
        assertThat(racingCars.getSize()).isEqualTo(2);
        assertThat(racingCars.getCars().get(0).getDistance()).isEqualTo(0);
    }

    @Test
    void createFalseTest(){
        assertThatThrownBy(() -> new RacingCar("test12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.MESSAGE_VALIDATE_NAME);
    }

    @Test
    void createTest(){
        RacingCar racingCar = new RacingCar("test");
        assertThat(racingCar.getName()).isEqualTo("test");
    }
}
