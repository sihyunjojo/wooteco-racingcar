package racingcar;

public class Car {
    private final String name;
    private Integer distances;

    public Car(String name) {
        this.name = name;
        this.distances = 0;
    }

    public void moveForward() {
        distances += 1;
    }

    public void displayRacing() {
        System.out.println(name + " : " + "-".repeat(distances));
    }
}
