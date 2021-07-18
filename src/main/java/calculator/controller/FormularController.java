package calculator.controller;

import calculator.service.FormularService;
import java.util.Scanner;

public class FormularController {

    private final FormularService formularService = new FormularService();

    public long calculator(Scanner scanner) {
        String inputLine = scanner.nextLine();
        return formularService.calculate(inputLine);
    }
}
