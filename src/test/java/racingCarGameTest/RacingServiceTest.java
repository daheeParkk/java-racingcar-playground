package racingCarGameTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingServiceTest {

    private static RacingService racingService;

    @BeforeAll
    public static void generateRacingService() {
        racingService = new RacingService();
    }

    @DisplayName("4 이상이면 true를 반환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,false","3,false","4,true","5,true"}, delimiter = ',')
    public void isFourOrMoreTest(int number, boolean result) {
        Assertions.assertThat(racingService.isFourOrMore(number)).isEqualTo(result);
    }
}
