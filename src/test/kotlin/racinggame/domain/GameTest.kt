package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `check making car`() {
        val carNumber = 3
        val car = RacingCar(0)
        val cars = listOf(
            car,
            car,
            car
        )
        val moving = 5
        val game = Game(cars, moving)

        assertThat(game.cars.size).isEqualTo(carNumber)
    }

    @Test
    fun `check game start condition`() {



    }
}
