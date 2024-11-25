package racinggame.domain


data class RacingCar(
    val carName: String,
    private var position: Int = 0,
) {
    fun moveCar(randomNumber: Int): ResultCode {
        if (checkIsMove(randomNumber)) {
            updatePosition()
            return ResultCode.SUCCESS
        }
        return ResultCode.FAIL
    }

    private fun checkIsMove(number: Int): Boolean {
        return number >= THRESHOLD
    }

    fun getCurrentPosition(): Int {
        return position
    }

    private fun updatePosition() {
        position += 1
    }

    companion object {
        private const val THRESHOLD = 4

        enum class ResultCode {
            SUCCESS,
            FAIL
        }
    }
}
