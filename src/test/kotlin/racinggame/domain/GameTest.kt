package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `check making car`() {
        val carName = "first,sec,third"
        val moving = 5
        val game = Game.createGame(carName, moving)

        assertThat(game.cars.size).isEqualTo(3)
    }
}
