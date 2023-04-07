package racingCarGame.view;

import racingCarGame.domain.RacingCars;

import java.util.List;

import static racingCarGame.message.ResultMessage.OUTPUT_RESULT_TEXT;
import static racingCarGame.message.ResultMessage.OUTPUT_WINNING_CAR;

public class ResultView {

    private static final String COLON = " : ";

    public void outputResultText() {
        System.out.println(OUTPUT_RESULT_TEXT.getMessage());
    }

    public void outputExecutionResult(RacingCars racingCars) {
        for (int i = 0; i < racingCars.getNumberOfCars(); i++) {
            String carName = racingCars.getNameByIndex(i);
            System.out.println(carName + COLON + racingCars.getStick(carName));
        }
        System.out.println();
    }

    public void outputWinningCar(List<String> winningCars) {
        String winningCar = winningCars.toString();
        System.out.println(winningCar.substring(1, winningCar.length() - 1) + OUTPUT_WINNING_CAR.getMessage());
    }
}
