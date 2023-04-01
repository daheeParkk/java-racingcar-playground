package racingCarGame.domain;

import racingCarGame.exception.CharacterLimitException;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) throws CharacterLimitException{
        checkNameLimit(name);
        this.name = name;
    }

    private void checkNameLimit(String name) throws CharacterLimitException{
        if (name.length() > 5) {
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
