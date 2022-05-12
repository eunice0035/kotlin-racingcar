package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameSpecs : DescribeSpec({

    val movements = listOf(
        1, 5, 3,
        2, 9, 4,
        3, 0, 1
    )

    val movementGenerator = PreparedMovementCommandGenerator(movements)

    describe("경주 게임은") {
        context("경주 수가 유효하면") {
            val numberOfRaces = 3
            val numberOfCars = 3
            val racingCars = RacingCars(
                List(numberOfCars) { Car() }
            )
            val racingGame = RacingGame(
                numberOfRaces,
                racingCars,
                movementGenerator
            )
            it("경주 수 만큼 경기를 진행하고 경주 결과를 반환한다") {
                val gameRecord = racingGame.play()
                gameRecord.also {
                    it.raceRecords.size shouldBe numberOfRaces
                    val lastStatesOfCar = it.raceRecords.last().cars
                    lastStatesOfCar[0].currentPosition shouldBe 0
                    lastStatesOfCar[1].currentPosition shouldBe 2
                    lastStatesOfCar[2].currentPosition shouldBe 1
                }
            }
        }
        context("경주 수가 유효하지 않다면") {
            val invalidNumberOfRaces = -1
            val racingCars = RacingCars(
                listOf(Car())
            )
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingGame(
                        invalidNumberOfRaces,
                        racingCars,
                        movementGenerator
                    )
                }
            }
        }
    }
})