package racinggame.domain;

object FindWinners {
    fun findWinners(cars:List<RacingCar>): List<RacingCar> {
        val maxPosition = cars.maxOf { it.getCurrentPosition() }
        return cars.filter{ it.getCurrentPosition() == maxPosition }
    }
}
