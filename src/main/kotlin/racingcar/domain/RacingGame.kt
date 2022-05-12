package racingcar.domain

class RacingGame(
    private val numberOfRaces: Int,
    private val racingCars: RacingCars,
    private val movementCommandGenerator: MovementCommandGenerator
) {

    init {
        require(numberOfRaces >= MINIMUM_NUMBER_OF_RACES) { "경주 횟수는 최소 $MINIMUM_NUMBER_OF_RACES 이상이어야 합니다." }
    }

    fun play(): GameRecord {
        val raceRecords = mutableListOf<RaceRecord>()

        repeat(numberOfRaces) {
            raceRecords.add(racingCars.race(movementCommandGenerator))
        }

        return GameRecord(raceRecords.toList())
    }

    companion object {
        private const val MINIMUM_NUMBER_OF_RACES = 1
    }
}

data class GameRecord(
    val raceRecords: List<RaceRecord>
)