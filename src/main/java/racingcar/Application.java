package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> carList = registerCar();
        int count = registerCount();

        playGame(count, carList);

        determineWinner();
        displayWinner();
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

    private static void determineWinner() {
    }

    private static void displayWinner() {
    }

    private static List<Car> registerCar() {
        List<Car> carList = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] carNameArray = input.split(",");

        //여기도 앞 뒤 공백을 제거 코드 필요.
        List<String> distinctCarNameList = Arrays.stream(carNameArray).
                distinct()
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

    private static boolean determineForward() {
        return Randoms.pickNumberInRange(1, 9) >= 4;
    }
}
