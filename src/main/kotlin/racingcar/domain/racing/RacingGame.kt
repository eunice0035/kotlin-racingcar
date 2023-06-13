package racingcar.domain.racing

import racingcar.domain.car.CarList
import racingcar.domain.record.RacingRecord

class RacingGame(
    private val carList: CarList,
    private val racingCondition: RacingCondition
) {

    fun start(): RacingRecord = carList.race(racingCondition.tryCount)
}