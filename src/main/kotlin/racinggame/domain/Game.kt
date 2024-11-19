package racinggame.domain

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

    fun startTurn() {
        cars.forEach { car ->
            car.moveCar()
        }
    }
}
