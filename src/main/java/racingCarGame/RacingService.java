package racingCarGame;

public class RacingService {

    private static final int MINIMUM_FORWARD_CONDITION = 4;

    public boolean isForwardCondition(int number) {
        return number >= MINIMUM_FORWARD_CONDITION;
    }
}
