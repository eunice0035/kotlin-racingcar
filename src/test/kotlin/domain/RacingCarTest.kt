package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalStateException
import org.junit.jupiter.api.Test

class RacingCarTest {

    private val racingCar = RacingCar(0, 5)

    @Test
    fun `update position - should be plus 1 than before`() {
        racingCar.updatePosition()
        val expected = 1
        assertThat(racingCar.position).isEqualTo(expected)
    }

    @Test
    fun `update remaining moves - should be minus 1 than before`() {
        racingCar.updateRemainingMoves()
        val expected = 4
        assertThat(racingCar.remainingMoves).isEqualTo(expected)
    }

    @Test
    fun `check move car - success`() {
        //Given
        racingCar.position = 1

        //WHEN
        racingCar.moveCar()

        //That
        val expectedPosition = 2
        val expectedRemainedTime = 4

        assertThat(racingCar.position).isEqualTo(expectedPosition)
        assertThat(racingCar.remainingMoves).isEqualTo(expectedRemainedTime)
    }

    @Test
    fun `check move car - fail and throw exception`() {
        racingCar.remainingMoves = 0
        assertThatIllegalStateException()
            .isThrownBy {  racingCar.moveCar() }
            .withMessage("The car can't be moved. There are no remaining moves")
    }
}