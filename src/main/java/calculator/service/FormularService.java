package calculator.service;

import calculator.repository.FormularRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormularService {

    private final FormularRepository formularRepository = new FormularRepository();
    private static long result = 0L;

    public long calculate(String inputLine) {
        parse(inputLine);

        List<String> formulars = formularRepository.getFormulars();

        result = Long.parseLong(formulars.get(0));

        int formularSize = formulars.size();
        for (int i = 1; i < formularSize; i += 2) {
            operate(formulars.get(i), formulars.get(i + 1));
        }

        return result;
    }

    private void operate(String operator, String operandStr) {
        long operand = Long.parseLong(operandStr);
        if (operator.equals("+")) {
            result += operand;
            return;
        }
        if (operator.equals("-")) {
            result -= operand;
            return;
        }
        if (operator.equals("*")) {
            result *= operand;
            return;
        }
        if (operator.equals("/")) {
            result /= operand;
            return;
        }

        throw new IllegalArgumentException("지원하지 않는 연산자가 포함되어 있습니다.");
    }

    private void parse(String inputLine) {
        String line = compress(inputLine);
        List<String> numbers = Arrays.stream(line.split("[+\\-*/]"))
            .collect(Collectors.toList());
        List<String> operations = Arrays.stream(line.split("[0-9]+"))
            .collect(Collectors.toList());

        int numbersSize = numbers.size();
        if (numbersSize != operations.size()) {
            throw new IllegalArgumentException("연산을 위한 피연산자가 부족합니다.");
        }

        formularRepository.add(numbers.get(0));
        for (int i = 1; i < numbersSize; i++) {
            formularRepository.add(operations.get(i));
            formularRepository.add(numbers.get(i));
        }
    }

    private String compress(String inputLine) {
        return inputLine.replaceAll("\\s", "");
    }
}
