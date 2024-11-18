package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    private val testCalculator = Calculator()

    @Test
    fun `plus operation - should return 3`() {
        val first = 0f
        val second = 1f
        val expected = 1f

        val actual = Calculator.Companion.OPERATOR.PLUS.calculate(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `minus operation - should return -1`() {
        val first = 1f
        val second = 2f
        val expected = -1f

        val actual = Calculator.Companion.OPERATOR.MINUS.calculate(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `multipleOperation - should return 30`() {
        val first = 5f
        val second = 6f
        val expected = 30f

        val actual = Calculator.Companion.OPERATOR.MULTIPLE.calculate(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `divideOperation - should return half`() {
        val first = 1f
        val second = 2f
        val exception = 0.5f

        val actual = Calculator.Companion.OPERATOR.DIVIDE.calculate(first, second)
        assertThat(actual).isEqualTo(exception)
    }

    @Test
    fun `throw exception - divided by 0`() {
        val first = 1f
        val second = 0f

        assertThrows<Exception> {
            Calculator.Companion.OPERATOR.DIVIDE.calculate(first, second)
        }
    }

    @Test
    fun `throw exception - equation is empty`() {
        val mockEquation = ""
        assertThrows<IllegalArgumentException> {
            testCalculator.checkIsValidEquation(mockEquation)
        }
    }

    @Test
    fun `throw exception - not convert to operator`() {
        val mockOperator = "."
        assertThrows<IllegalArgumentException> {
            Calculator.Companion.OPERATOR.valueOf(mockOperator)
        }
    }

    @Test
    fun `return right enum class`() {
        val mockOperator = "+"
        val exception = Calculator.Companion.OPERATOR.PLUS
        val actual = Calculator.Companion.OPERATOR.fromSymbol(mockOperator)

        assertThat(actual).isEqualTo(exception)
    }

    @Test
    fun `test getResult - print right answer`() {
        val equation = "3+5"
        val exception = 8f
        val actual = testCalculator.getResult(equation)
        assertThat(actual).isEqualTo(exception)
    }
}
