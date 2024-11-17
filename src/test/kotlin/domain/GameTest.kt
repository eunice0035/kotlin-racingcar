package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameTest {
    private val game = Game()

    @Test
    fun `check making car`() {
        val carNumber = 3
        val moving = 5
        game.makingCar(carNumber, moving)

        assertThat(game.carList.size).isEqualTo(carNumber)
    }

    @Test
    fun `check moving of car`() {
        val carNumber = 3
        val moving = 5
        game.makingCar(carNumber, moving)
        assertThat(game.carList.map { it.remainingMoves == moving }.size).isEqualTo(carNumber)
    }
}