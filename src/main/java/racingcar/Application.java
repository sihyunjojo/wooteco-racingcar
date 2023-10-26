package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = registerCarName();
        int count = registerCount();

    }
    private static List<String> registerCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carArray = input.split(",");
        // 자동차 이름은 ,를 기준으로 5개 이하만 입력 가능하다.
        List<String> carList = new ArrayList<>();

        //여기도 앞 뒤 공백을 제거 코드 필요.
        for (String carName : carArray) {
            if (!carList.contains(carName)) {
                carList.add(carName);
            }
        }

        return carList;
    }

    private static int registerCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
