package racingCarGame.view;

import racingCarGame.domain.RacingCars;
import racingCarGame.service.CarService;

import java.util.List;

public class ResultView {

    private final CarService carService = new CarService();

    public void outputResultText() {
        System.out.println("\n실행 결과");
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
        System.out.println(winningCar.substring(1, winningCar.length()-1) + "가 최종 우승했습니다.");
    }
}
