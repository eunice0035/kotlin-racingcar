package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Cars(private val cars: List<Car>) {

    fun moveAll() = cars.forEach { car -> car.move() }

    fun getPositions() = cars.map(Car::position)

    fun getCurrentInfos() = cars.map(Car::getCurrentInfo)

    companion object {
        fun of(movingStrategy: MovingStrategy, names: List<String>): Cars {
            val cars = List(names.size) { Car(movingStrategy, names[it]) }
            return Cars(cars)
        }
    }
}