package calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class FormularRepository {

    private static final List<String> formularRepository = new ArrayList<>();

    public void add(String value) {
        formularRepository.add(value);
    }

    public List<String> getFormulars() {
        return formularRepository;
    }
}
