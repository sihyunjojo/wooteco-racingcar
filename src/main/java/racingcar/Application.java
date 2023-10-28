package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Car> carList = registerCar();
        int count = registerCount();

        playGame(count, carList);

        List<Car> winnerCars = determineWinner(carList);

        displayWinner(winnerCars);

        Console.close();

    }

    private static List<Car> registerCar() {
        List<Car> carList = new ArrayList<>();
        String[] carNames = inputCarNames();

        List<String> CarNameList = preprocessCarNames(carNames);

        for (String carName : CarNameList) {
            carList.add(new Car(carName.trim()));
        }

        return carList;
    }

    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return inputSplit(input);
    }

    private static String[] inputSplit(String input) {
        return input.split(",");
    }

    private static List<String> preprocessCarNames(String[] carNames) {
        List<String> CarNameList = removeDuplicates(carNames);
        CarNameList = limitListSize(CarNameList);
        return CarNameList;
    }


    private static List<String> removeDuplicates(String[] carNameArray) {
        return Arrays.stream(carNameArray)
                .distinct()
                .toList();
    }

    private static List<String> limitListSize(List<String> CarNameList) {
        if (CarNameList.size() > 5) {
            return CarNameList.subList(0, 5);
        }
        return CarNameList;
    }

    private static int registerCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        System.out.println();

        return Integer.parseInt(input);
    }


    private static void playGame(int count, List<Car> carList) {
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            for (Car car : carList) {
                car.moveForward();
                car.displayRacing();
            }
            System.out.println();
        }
    }

    private static List<Car> determineWinner(List<Car> carList) {
        int topDistance = determineTovDistance(carList);

        return carList.stream()
                .filter(car ->
                        car.getDistances() == topDistance
                ).toList();
    }

    private static int determineTovDistance(List<Car> carList) {
        int topDistance = 0;
        for (Car car : carList) {
            if (topDistance < car.getDistances()) {
                topDistance = car.getDistances();
            }
        }
        return topDistance;
    }

    private static void displayWinner(List<Car> winnerCars) {
        System.out.println("최종 우승자 : " + winnerCars.stream()
                .map(Car::getName)
                .collect(
                        Collectors.joining(", ")
                ));
    }

}
