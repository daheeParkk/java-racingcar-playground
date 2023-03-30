package calculatorTest;

import calculator.controller.CalculatorController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.controller.CalculatorController.EMPTY_STRING_VALUE;
import static org.assertj.core.api.Assertions.*;

public class PlusCalculatorTest {

    private static CalculatorController calculator;

    @BeforeAll
    public static void generateCalculatorController() {

        calculator = new CalculatorController();
    }

    @DisplayName("콤마 또는 콜론을 구분자로 가질 경우")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1,2,3=6", "1,2,3,4=10"}, delimiter = '=')
    public void calculateCommaAndColonDelimiterTest(String addition, int result) throws Exception {

        assertThat(calculator.splitAndSum(addition)).isEqualTo(result);
    }

    @DisplayName("커스텀한 구분자를 가질 경우")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=6", "//+\\n5+3=8"}, delimiter = '=')
    public void calculateCustomDelimiterTest(String addition, int result) throws Exception {

        assertThat(calculator.splitAndSum(addition)).isEqualTo(result);
    }

    @DisplayName("숫자 하나를 입력할 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void inputOneNumberTest(String addition) throws Exception {

        assertThat(calculator.splitAndSum(addition)).isEqualTo(Integer.parseInt(addition));
    }

    @DisplayName("빈 문자열을 입력하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void inputEmptyStringTest(String addition) throws Exception {

        assertThat(calculator.splitAndSum(addition)).isEqualTo(EMPTY_STRING_VALUE);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "-1,2,3", "1,-5,a"})
    public void notNumberFormat(String addition) {

        assertThatThrownBy(() -> calculator.splitAndSum(addition)).isInstanceOf(RuntimeException.class);
    }

}
