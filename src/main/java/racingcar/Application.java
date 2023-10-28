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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] carNameArray = input.split(",");

        //여기도 앞 뒤 공백을 제거 코드 필요.
        List<String> distinctCarNameList = Arrays.stream(carNameArray)
                .distinct()
                .toList();

        if (distinctCarNameList.size() > 5) {
            distinctCarNameList = distinctCarNameList.subList(0, 5);
        }

        for (String carName : distinctCarNameList) {
            carList.add(new Car(carName));
        }

        return carList;
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
                if (determineForward()) {
                    car.moveForward();
                }
                car.displayRacing();
            }
            System.out.println();
        }
    }


    private static boolean determineForward() {
        return Randoms.pickNumberInRange(1, 9) >= 4;
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
