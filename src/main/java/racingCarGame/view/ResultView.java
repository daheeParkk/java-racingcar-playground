package racingCarGame.view;

import racingCarGame.domain.RacingCars;
import racingCarGame.service.CarService;

import java.util.List;

public class ResultView {

    private final CarService carService = new CarService();

    public void outputExecutionResult(RacingCars racingCars) {
        System.out.println("실행 결과");
        for (int i=0; i< racingCars.getNumberOfCars(); i++) {
            String carName = racingCars.getNameByIndex(i);
            System.out.println(carName + " : " + carService.getStick(carName) + "\n");
        }
    }

    public void outputWinningCar(List<String> winningCars) {
        String winningCar = winningCars.toString().substring(1, winningCars.size());
        System.out.print(winningCar + "가 최종 우승했습니다.");
    }
}
