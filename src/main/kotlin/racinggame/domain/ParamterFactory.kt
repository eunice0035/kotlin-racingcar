package racinggame.domain

interface ParameterFactory {
    fun createCars(number: Int): List<RacingCar>
}

class GameParameter : ParameterFactory {
    override fun createCars(number: Int): List<RacingCar> {
        val cars = mutableListOf<RacingCar>()
        repeat(number) {
            cars.add(RacingCar())
        }
        return cars.toList()
    }
}