package racinggame.domain

import kotlin.random.Random
import kotlin.random.nextInt

class Game(val cars: List<RacingCar>, val totalGameTurn: Int) {
    private var gameTurn = totalGameTurn
    private fun generateRandomNumber(): Int {
        return Random.nextInt(START_RANGE..END_RANGE)
    }

    fun startTurn() {
        if (checkIsGameStart()) {
            updateGameTurn()
            cars.forEach { car ->
                car.moveCar(generateRandomNumber())
            }
        }
    }

    private fun checkIsGameStart(): Boolean {
        return gameTurn > 0
    }

    private fun updateGameTurn() {
        gameTurn--
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
        private const val DELIMITER = ","

        fun createGame(carName: String, initMoving: Int): Game {
            val cars = carName.split(DELIMITER).map { RacingCar(it, 0) }
            return Game(cars, initMoving)
        }
    }
}
    