package domain

data class RacingCar(
    var position: Int = 0,
    var remainingMoves: Int
) {
    private fun isMove() {
        check(remainingMoves > 0) {
            "The car can't be moved. There are no remaining moves"
        }
    }

    fun moveCar() {
        isMove()
        updateRemainingMoves()
        updatePosition()
    }

    fun updatePosition() {
        position += 1
    }

    fun updateRemainingMoves() {
        remainingMoves -= 1
    }
}
