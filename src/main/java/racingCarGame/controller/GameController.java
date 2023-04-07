package racingCarGame.controller;

import racingCarGame.domain.RacingCars;
import racingCarGame.exception.CharacterLimitException;
import racingCarGame.exception.DuplicateException;
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
    private RacingCars racingCars;
    private int numberToTry;

    public void playGame() {
        inputCars();
        numberToTry = inputView.inputNumberToTry();
        resultView.outputResultText();
        moveCarsOrNot();
        resultView.outputWinningCar(findWinningCar());
    }

    private void inputCars() {
        while (!correctInput) {
            try {
                inputCarsNames();
            } catch (CharacterLimitException | DuplicateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputCarsNames() {
        String carsNames = inputView.inputCarNames();
        racingCars = carService.generateCars(carsNames);
        correctInput = true;
    }

    private List<String> findWinningCar() {
        int maxPosition = carService.findMaxPosition(racingCars);
        return racingService.findWinningCar(maxPosition, racingCars);
    }

    private void moveCarsOrNot() {
        for (int i = 0; i < numberToTry; i++) {
            racingService.moveCarsOrNot(racingCars);
            resultView.outputExecutionResult(racingCars);
        }
    }
}
