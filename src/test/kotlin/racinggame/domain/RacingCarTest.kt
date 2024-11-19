package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {
    private val racingCar = RacingCar()

    @Test
    fun `update position - should be plus 1 than before`() {
        racingCar.updatePosition()
        val expected = 1
        assertThat(racingCar.getCurrentPosition()).isEqualTo(expected)
    }

    @Test
    fun `check movable`() {
        val number = 4
        val expected = true
        assertThat(racingCar.checkIsMove(number)).isEqualTo(expected)
    }
}
