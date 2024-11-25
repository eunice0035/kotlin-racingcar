package racinggame.domain


data class RacingCar(
    val carName: String,
    private var position: Int = 0,
) {

    init {
        checkIsValidCarName()
        checkCarNameLength()
    }

    fun checkIsValidCarName(){
        require(carName.isNotEmpty()) {
            "Car name must not be Empty"
        }
    }

    fun checkCarNameLength() {
        require(carName.length <=5) {
            "The length of car name must not be longer than 5"
        }
    }

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
