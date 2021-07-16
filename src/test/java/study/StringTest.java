package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() throws Exception {
        // given
        String str = "1,2";

        // when
        String[] splited = str.split(",");

        // then
        assertThat(splited.length).isEqualTo(2);

        assertThat(splited[0]).isEqualTo("1");
        assertThat(splited[1]).isEqualTo("2");

        assertThat(splited).contains("1");
        assertThat(splited).contains("2");
        assertThat(splited).containsExactly("1", "2");
    }

    @Test
    void substring() throws Exception {
        // given
        String str = "(1,2)";

        // when
        String substr = str.substring(1, str.length() - 1);

        // then
        assertThat(substr).isEqualTo("1,2");
    }

    @DisplayName("문자열 접근 범위를 벗어난 경우")
    @Test
    void charAt() throws Exception {
        // given
        String str = "abc";
        
        // when
        // then
        // 예외 타입 매칭
        assertThatThrownBy(() -> {
            char c = str.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        // 예외 발생 시 반환되는 메시지 매칭
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                str.charAt(15);
            }).withMessageMatching("String index out of range: \\d+");
    }
}
