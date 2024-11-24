package racinggame.domain

interface ParameterFactory {
    fun createCars(names: List<String>): List<RacingCar>
}

class GameParameter : ParameterFactory {
    override fun createCars(names: List<String>): List<RacingCar> {
        return names.map { name ->
            RacingCar(name, 0)
        }
    }

    fun getCarName(name: String) = name.split(DELIMITER)

    companion object {
        const val DELIMITER = ","
    }
}