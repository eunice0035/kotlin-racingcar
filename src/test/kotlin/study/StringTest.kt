package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isBlank() {
        val actual = "".isBlank()
        print(actual)
        assertThat(actual).isEqualTo(true)
    }
}
