package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size() throws Exception {
        // given
        // when
        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsV1(int arg) throws Exception {
        // 중복 코드
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();

        // 중복 개선
        assertThat(numbers.contains(arg)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,1", "3,1", "4,0", "5,0"}, delimiter = ',')
    void containsV2(String arg, String expected) throws Exception {
        // given
        boolean expectedBool = expected.equals("1");

        // when
        // then
        assertThat(numbers.contains(Integer.parseInt(arg))).isEqualTo(expectedBool);
    }
}
