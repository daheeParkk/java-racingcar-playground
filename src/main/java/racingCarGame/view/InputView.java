package racingCarGame.view;

import java.util.Scanner;

import static racingCarGame.utils.InputMessage.INPUT_CAR_NAME;
import static racingCarGame.utils.InputMessage.INPUT_NUMBER_TO_TRY;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAME);
        return scanner.nextLine();
    }

    public int inputNumberToTry() {
        System.out.println(INPUT_NUMBER_TO_TRY);
        return Integer.parseInt(scanner.nextLine());
    }
}
