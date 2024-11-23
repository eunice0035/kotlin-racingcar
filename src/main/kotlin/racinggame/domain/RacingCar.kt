package racinggame.domain

import kotlin.random.Random
import kotlin.random.nextInt

data class RacingCar(
    private var position: Int = 0,
) {
    fun moveCar(): ResultCode {
        val randomNumber = generateRandomNumber()
        if (checkIsMove(randomNumber)) {
            updatePosition()
            return ResultCode.SUCCESS
        }
        return ResultCode.FAIL
    }

    private fun checkIsMove(number: Int): Boolean {
        return number >= THRESHOLD
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(START_RANGE..END_RANGE)
    }

    fun getCurrentPosition(): Int {
        return position
    }

    private fun updatePosition() {
        position += 1
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
        private const val THRESHOLD = 4

        enum class ResultCode {
            SUCCESS,
            FAIL
        }
    }
}
