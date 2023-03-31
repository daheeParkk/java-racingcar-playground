package racingCarGame.domain;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
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
