package racingCarGame.controller;

import racingCarGame.domain.RacingCars;
import racingCarGame.exception.CharacterLimitException;
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

    private boolean correctInput = false;

    public void playGame() {

        RacingCars racingCars = null;

        while (!correctInput) {
            try {
                String carsNames = inputView.inputCarNames();
                racingCars = carService.generateCars(carsNames);
                correctInput = true;
            } catch (CharacterLimitException e) {
                System.out.println(e.getMessage());
            }
        }
        int numberToTry = inputView.inputNumberToTry();

        moveCarsOrNot(racingCars, numberToTry);

        resultView.outputWinningCar(findWinningCar(racingCars));
    }

    private List<String> findWinningCar(RacingCars racingCars) {
        int maxPosition = carService.findMaxPosition(racingCars);
        return racingService.findWinningCar(maxPosition, racingCars);
    }

    private void moveCarsOrNot(RacingCars racingCars, int numberToTry) {
        racingService.generateRandomTime(System.currentTimeMillis());
        resultView.outputResultText();

        for (int i=0; i<numberToTry; i++) {
            racingService.moveCarsOrNot(racingCars);
            resultView.outputExecutionResult(racingCars);
        }
    }
}
