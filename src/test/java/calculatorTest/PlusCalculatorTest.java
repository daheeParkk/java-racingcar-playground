package calculatorTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlusCalculatorTest {

    @BeforeAll
    public static void generateCalculatorController() {
        final CalculatorController calculator = new CalculatorController();
        int result;
    }

    @DisplayName("콤마 또는 콜론을 구분자로 가질 경우")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3","1,2,3=6"}, delimiter = '=')
    public void separateCommaAndColonTest(String addition, int result) {
        int testResult = calculator.splitAndSum(addition);
        Assertions.assertThat(testResult).isEqualTo(result);
    }
}
