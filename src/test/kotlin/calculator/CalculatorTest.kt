package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val testCalculator = Calculator()

    @Test
    fun `plus operation - should return 3`() {
        val first = 0f
        val second = 1f
        val expected = 1f

        val actual = testCalculator.plusOperation(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `minus operation - should return -1`() {
        val first = 1f
        val second = 2f
        val expected = -1f

        val actual = testCalculator.minusOperation(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `multipleOperation - should return 30`() {
        val first = 5f
        val second = 6f
        val expected = 30f

        val actual = testCalculator.multipleOperation(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `divideOperation - should return half`() {
        val first = 1f
        val second = 2f
        val exception = 0.5f

        val actual = testCalculator.divideOperation(first, second)
        assertThat(actual).isEqualTo(exception)
    }
}
