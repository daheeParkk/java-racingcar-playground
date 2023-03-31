package racingCarGame.controller;

import racingCarGame.domain.RacingCars;
import racingCarGame.service.CarService;
import racingCarGame.service.RacingService;
import racingCarGame.view.InputView;
import racingCarGame.view.ResultView;

import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final RacingService racingService = new RacingService();
    private final CarService carService = new CarService();

    public void playGame() {

        String carsNames = inputView.inputCarNames();
        int numberToTry = inputView.inputNumberToTry();
        RacingCars racingCars = carService.generateCars(carsNames);

        moveCarsOrNot(racingCars, numberToTry);

        resultView.outputWinningCar(findWinningCar(racingCars));
    }

    private List<String> findWinningCar(RacingCars racingCars) {
        int maxPosition = carService.findMaxPosition(racingCars);
        return racingService.findWinningCar(maxPosition, racingCars);
    }

    private void moveCarsOrNot(RacingCars racingCars, int numberToTry) {
        racingService.generateRandomTime(System.currentTimeMillis());

        for (int i=0; i<numberToTry; i++) {
            racingService.moveCarsOrNot(racingCars);
            resultView.outputExecutionResult(racingCars);
        }
    }
}
