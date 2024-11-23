package racinggame.domain


import kotlin.random.Random
import kotlin.random.nextInt

class Game(carNumber: Int, initMoving: Int) {
    val totalGameTurn = initMoving
    val cars: List<RacingCar> by lazy {
        makingCars(carNumber)
    }

    private fun makingCars(number: Int): List<RacingCar> {
        val initCars = mutableListOf<RacingCar>()
        repeat(number) {
            initCars.add(RacingCar())
        }
        return initCars
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(START_RANGE..END_RANGE)
    }

    fun startTurn() {
        cars.forEach { car ->
            car.moveCar(generateRandomNumber())
        }
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
    }
    