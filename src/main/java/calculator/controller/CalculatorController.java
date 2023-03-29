package calculator.controller;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    private static List<String> numberAndSeparator;
    private static int sumResult;

    public int splitAndSum(String expression) {

        splitExpression(expression);
        int result = 0;

        if (numberAndSeparator.get(1).equals(",") || numberAndSeparator.get(1).equals(";")) {
            result = sumNumbers(1);
        }
        return result;
    }

    private int sumNumbers(int index) {

        String beforeNumber;
        String afterNumber;

        if (index + 1 < numberAndSeparator.size()) {

            beforeNumber = numberAndSeparator.get(index - 1);
            afterNumber = numberAndSeparator.get(index + 1);

            sumResult = Integer.parseInt(beforeNumber) + Integer.parseInt(afterNumber);
            numberAndSeparator.remove(index + 1);
            numberAndSeparator.add(index + 1, String.valueOf(sumResult));
            index += 2;
            sumNumbers(index);
        }
        return sumResult;
    }

    private void splitExpression(String expression) {

        numberAndSeparator = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            numberAndSeparator.add(String.valueOf(expression.charAt(i)));
        }
    }
}
