package racinggame.domain

class Game(
    val cars: List<RacingCar>,
    val totalGameTurn: Int,
    private val generator: RandomNumberGenerator,
) {
    private var gameTurn = totalGameTurn
    var onTurnCompleted: ((Int, List<RacingCar>) -> Unit)? = null

    fun startGame() {
        while (totalGameTurn > 0) {
            startTurn()
            onTurnCompleted?.invoke(gameTurn, cars)
        }
    }

    private fun startTurn() {
        if (checkIsGameStart()) {
            updateGameTurn()
            cars.forEach { car ->
                car.moveCar(generator.generate())
            }
        }
    }

    private fun checkIsGameStart(): Boolean {
        return gameTurn > 0
    }

    private fun updateGameTurn() {
        gameTurn--
    }

    fun getResult(): List<RacingCar> {
        return GameResult.findWinners(cars)
    }

    companion object {
        private const val DELIMITER = ","

        fun createGame(
            carName: String,
            initMoving: Int,
        ): Game {
            val cars = carName.split(DELIMITER).map { RacingCar(it, 0) }
            return Game(cars, initMoving, RandomNumberGenerator)
        }
    }
}
