package calculatorTest;

import calculator.controller.CalculatorController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlusCalculatorTest {

    private static CalculatorController calculator;

    @BeforeAll
    public static void generateCalculatorController() {
        calculator = new CalculatorController();
    }

    @DisplayName("콤마 또는 콜론을 구분자로 가질 경우")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3","1,2,3=6", "1,2,3,4=10"}, delimiter = '=')
    public void calculateCommaAndColonDelimiterTest(String addition, int result) {
        Assertions.assertThat(calculator.splitAndSum(addition)).isEqualTo(result);
    }

    @DisplayName("커스텀한 구분자를 가질 경우")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=6","//+\\n5+3=8"}, delimiter = '=')
    public void calculateCustomDelimiterTest(String addition, int result) {
        Assertions.assertThat(calculator.splitAndSum(addition)).isEqualTo(result);
    }
}
