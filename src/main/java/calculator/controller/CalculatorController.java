package calculator.controller;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    public static final int EMPTY_STRING_VALUE = 0;
    private static final int FIRST_SEPARATOR_INDEX = 1;
    private static final int FIRST_CUSTOM_SEPARATOR_INDEX = 6;
    private static final int NEXT_INDEX = 1;
    private static final int PREVIOUS_INDEX = 1;
    private static final int NEXT_NUMBER_INDEX = 2;

    private static List<String> numberAndSeparator;
    private static int sumResult;
    private static int result;
    private static int firstSeparatorIndex;

    public int splitAndSum(String expression) throws Exception {

        if (isEmpty(expression) || isOneNumber(expression)) {
            return result;
        }
        splitExpression(expression);
        checkMinusNumber();
        sumBySeparator();

        return result;
    }

    private void checkMinusNumber() {

        if (numberAndSeparator.contains("-")) {
            throw new RuntimeException();
        }

    }

    private boolean isEmpty(String expression) {

        if (expression.trim().isEmpty()) {
            result = EMPTY_STRING_VALUE;
            return true;
        }
        return false;
    }

    private boolean isOneNumber(String expression) {

        if (expression.length() == 1) {
            result = Integer.parseInt(expression);
            return true;
        }
        return false;
    }

    private void sumBySeparator() throws Exception {

        if (isCommaOrColonSeparator() || isCustomSeparator()) {
            isNumberFormat();
            result = sumNumbers(firstSeparatorIndex);
        }
    }

    private void isNumberFormat() throws Exception {

        int index = firstSeparatorIndex - PREVIOUS_INDEX;
        while (index < numberAndSeparator.size()) {
            isNumeric(index);
            index += NEXT_NUMBER_INDEX;
        }
    }

    private void isNumeric(int index) throws Exception {

        if (!numberAndSeparator.get(index).chars().allMatch(Character::isDigit)) {
            throw new RuntimeException();
        }
    }

    private boolean isCustomSeparator() {

        if (numberAndSeparator.get(FIRST_SEPARATOR_INDEX).equals("/")) {
            firstSeparatorIndex = FIRST_CUSTOM_SEPARATOR_INDEX;
            return true;
        }
        return false;
    }

    private boolean isCommaOrColonSeparator() {

        if (numberAndSeparator.get(FIRST_SEPARATOR_INDEX).equals(",") || numberAndSeparator.get(FIRST_SEPARATOR_INDEX).equals(";")) {
            firstSeparatorIndex = FIRST_SEPARATOR_INDEX;
            return true;
        }
        return false;
    }

    private int sumNumbers(int index) {

        if (index + NEXT_INDEX < numberAndSeparator.size()) {

            String beforeNumber = numberAndSeparator.get(index - PREVIOUS_INDEX);
            String afterNumber = numberAndSeparator.get(index + NEXT_INDEX);

            sumResult = Integer.parseInt(beforeNumber) + Integer.parseInt(afterNumber);
            numberAndSeparator.remove(index + NEXT_INDEX);
            numberAndSeparator.add(index + NEXT_INDEX, String.valueOf(sumResult));
            index += NEXT_NUMBER_INDEX;
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
