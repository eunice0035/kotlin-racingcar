package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `check making car`() {
        val carNumber = 3
        val moving = 5
        val game = Game(carNumber, moving)

        assertThat(game.cars.size).isEqualTo(carNumber)
    }
}
