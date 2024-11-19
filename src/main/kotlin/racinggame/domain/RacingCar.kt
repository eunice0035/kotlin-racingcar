package racinggame.domain

import kotlin.random.Random
import kotlin.random.nextInt

data class RacingCar(
    private var position: Int = 0,
) {
    fun checkIsMove(number: Int): Boolean {
        return number >= 4
    }

    fun moveCar() {
        val randomNumber = generateRandomNumber()
        if (checkIsMove(randomNumber)) updatePosition()
    }

    fun generateRandomNumber(): Int {
        return Random.nextInt(START_RANGE..END_RANGE)
    }

    fun getCurrentPosition(): Int {
        return position
    }

    fun updatePosition() {
        position += 1
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
    }
}
