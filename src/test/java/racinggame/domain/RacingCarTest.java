package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.Message;
import racinggame.controller.GameController;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingResult;
import racinggame.domain.Winner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    RacingCars racingCars;
    RacingCar racingCar;

    @BeforeEach
    void setUp(){
       racingCars = new RacingCars("pobi,crong,honux");
       racingCar = new RacingCar("pobi");
    }

    @Test
    @DisplayName("TDD 강의 듣고 연습해본 레이싱카 게임 실행 테스트.")
    void carsMoveTest(){
        System.out.println("실행 결과");
        for (int i = 0; i < 5; i++) {
            RacingResult racingResult = racingCars.race();
            racingResult.printResult();
        }
        Winner winner = new Winner(racingCars);
        winner.findWinnerName();
        System.out.println(String.format("최종 우승자는 %s 입니다.", winner.printWinners()));
    }

    @Test
    @DisplayName("여러대가 나와도 5자 이상인 것이 있으면 생성되지 않도록 하는 테스트.")
    void createManyCarFailTest(){
        assertThatThrownBy(() -> new RacingCar("test1,test12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.MESSAGE_VALIDATE_NAME);
    }

    @Test
    @DisplayName("쉼표로 구분되었을 경우, 여러대의 자동차를 생성해주는 테스트.")
    void createManyCarTest(){
        assertThat(racingCars.getSize()).isEqualTo(3);
        assertThat(racingCars.getRacingCars().get(0).getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자열일 경우 에러를 보여주는 테스트.")
    void createFalseNoNameTest(){
        assertThatThrownBy(() -> new RacingCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.MESSAGE_VALIDATE_MIN_LENGTH);
    }

    @Test
    @DisplayName("5자리 이상이면 생성되지 않도록 에러를 보여주는 테스트.")
    void createFalseTest(){
        assertThatThrownBy(() -> new RacingCar("test12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.MESSAGE_VALIDATE_NAME);
    }

    @Test
    @DisplayName("생성이 제대로 되었는지 확인하는 테스트.")
    void createTest(){
        RacingCar racingCar = new RacingCar("test");
        assertThat(racingCar.getName()).isEqualTo("test");
    }
}
