package calculator;

import calculator.controller.FormularController;
import java.util.Scanner;

public class CalculatorApplication {

    /**
     * 단위 테스트 실습 - 문자열 계산기
     * input = "2 + 3 * 4 / 2"
     * output = "result = 5"
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final FormularController controller = new FormularController();
        long result = controller.calculator(scanner);
        System.out.println("result = " + result);
        scanner.close();
    }
}
