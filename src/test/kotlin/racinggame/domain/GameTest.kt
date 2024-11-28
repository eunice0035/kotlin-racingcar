package racinggame.domain

import io.kotest.matchers.shouldBe
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

    @Test
    fun verifyCallbackInvocation() {
        val carName = "first,sec,third"
        val moving = 5
        val game = Game.createGame(carName, moving)

        var callbackNum = 0
        val mockCallback: (Int, List<RacingCar>) -> Unit = { turn, cars ->
            callbackNum++
        }
        game.onTurnCompleted = mockCallback
        game.startGame()

        callbackNum shouldBe moving
    }
}
