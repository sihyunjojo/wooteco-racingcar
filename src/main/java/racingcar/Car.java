package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int distances;

    public Car(String name) {
        this.name = name;
        this.distances = 0;
    }

    public void moveForward() {
        if (Randoms.pickNumberInRange(1, 9) >= 4) {
            distances += 1;
        }
    }

    public void displayRacing() {
        System.out.println(name + " : " + "-".repeat(distances));
    }

    public int getDistances() {
        return distances;
    }

    public String getName(){
        return name;
    }
}
