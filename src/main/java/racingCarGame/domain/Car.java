package racingCarGame.domain;

import racingCarGame.exception.CharacterLimitException;

public class Car {

    private static final int STARTING_POSITION = 0;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private final String name;

    private int position = STARTING_POSITION;

    public Car(String name) throws CharacterLimitException {

        checkNameLimit(name);
        this.name = name;
    }

    private void checkNameLimit(String name) throws CharacterLimitException {

        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new CharacterLimitException();
        }
    }

    public String getName() {

        return name;
    }

    public int getPosition() {

        return position;
    }

    public void movePosition() {

        position++;
    }

    public boolean isEqual(String name) {

        return this.name.equals(name);
    }
}
