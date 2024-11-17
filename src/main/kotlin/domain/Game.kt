package domain

import kotlin.random.Random

class Game {
    var carList = mutableListOf<RacingCar>()

    fun makingCar(number: Int, moving: Int) {
        repeat(number) {
            carList.add(RacingCar(remainingMoves = moving))
        }
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(0, 10)
    }

    fun movingAllCar() {
        carList.forEach { car ->
            if (generateRandomNumber() > 3) {
                car.moveCar()
            } else {
                car.updateRemainingMoves()
            }
        }
    }
}