package racingCarGame.view;

import racingCarGame.domain.RacingCars;
import racingCarGame.service.CarService;

import java.util.List;

import static racingCarGame.utils.ResultMessage.OUTPUT_RESULT_TEXT;
import static racingCarGame.utils.ResultMessage.OUTPUT_WINNING_CAR;

public class ResultView {

    private final CarService carService = new CarService();

    public void outputResultText() {
        System.out.println(OUTPUT_RESULT_TEXT.getMessage());
    }

    public void outputExecutionResult(RacingCars racingCars) {
        for (int i=0; i< racingCars.getNumberOfCars(); i++) {
            String carName = racingCars.getNameByIndex(i);
            System.out.println(carName + " : " + carService.getStick(carName));
        }
        System.out.println("");
    }

    public void outputWinningCar(List<String> winningCars) {
        String winningCar = winningCars.toString();
        System.out.println(winningCar.substring(1, winningCar.length()-1) + OUTPUT_WINNING_CAR.getMessage());
    }
}
