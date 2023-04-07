package racingCarGameTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCarGame.domain.RacingCars;
import racingCarGame.exception.CharacterLimitException;
import racingCarGame.exception.DuplicateException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @DisplayName("자동차 이름이 5글자를 초과할 경우")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef,abcdefg", "ab,abc,abcdef"})
    public void characterLimitExceptionTest(String carsNames) {
        assertThatThrownBy(() -> RacingCars.from(carsNames)).
                isInstanceOf(CharacterLimitException.class);
    }

    @DisplayName("자동차 이름이 중복일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"abc,abc,qwe", "dahee,hui,dahee", "bob,bob"})
    public void DuplicateExceptionTest(String carsNames) {
        assertThatThrownBy(() -> RacingCars.from(carsNames))
                .isInstanceOf(DuplicateException.class);
    }
}
