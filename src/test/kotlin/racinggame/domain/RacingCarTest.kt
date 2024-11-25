package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racinggame.domain.RacingCar.Companion.ResultCode

class RacingCarTest {
    private val racingCar = RacingCar("test", 0)

    @Test
    fun `moveCar Success - should be plus 1 than before`() {
        val previousPosition = racingCar.getCurrentPosition()

        racingCar.moveCar(5)
        val currentPosition = racingCar.getCurrentPosition()

        assertThat(previousPosition + 1).isEqualTo(currentPosition)
    }

    @Test
    fun `moveCar Fail - should be equal before`() {
        val previousPosition = racingCar.getCurrentPosition()

        racingCar.moveCar(1)
        val currentPosition = racingCar.getCurrentPosition()

        assertThat(previousPosition).isEqualTo(currentPosition)
    }

    @Test
    fun `check movable- success`() {
        val number = 4
        val expected = ResultCode.SUCCESS

        val result = racingCar.moveCar(number)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `check movable - fail`() {
        val number = 0
        val expected = ResultCode.FAIL

        val result = racingCar.moveCar(number)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `check carName - valid car name`() {
        val car = RacingCar("Speed")
        assertEquals("Speed", car.carName)
    }

    @Test
    fun `car name is empty should throw exception`() {
        assertThrows<IllegalArgumentException> {
            RacingCar("", 0)
        }
    }

    @Test
    fun `car name exceeds 5 characters should throw exception`() {
        assertThrows<IllegalArgumentException> {
            RacingCar("123456", 0)
        }
    }
}
