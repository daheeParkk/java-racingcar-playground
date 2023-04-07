package racingCarGame.controller;

import racingCarGame.domain.RacingCars;
import racingCarGame.exception.CharacterLimitException;
import racingCarGame.exception.DuplicateException;
import racingCarGame.utils.RandomNumber;
import racingCarGame.view.InputView;
import racingCarGame.view.ResultView;

import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final RandomNumber randomNumber = new RandomNumber();

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
        racingCars = RacingCars.from(carsNames);
        correctInput = true;
    }

    private List<String> findWinningCar() {
        int maxPosition = racingCars.findMaxPosition();
        return racingCars.findWinningCar(maxPosition);
    }

    private void moveCarsOrNot() {
        for (int i = 0; i < numberToTry; i++) {
            racingCars.tryMoveCars(randomNumber.generateRandomNumber());
            resultView.outputExecutionResult(racingCars);
        }
    }
}
