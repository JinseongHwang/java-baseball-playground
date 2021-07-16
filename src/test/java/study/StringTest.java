package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
