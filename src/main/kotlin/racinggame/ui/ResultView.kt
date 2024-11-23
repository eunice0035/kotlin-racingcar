package racinggame.ui

import racinggame.domain.RacingCar

class ResultView {
    fun printResult(
        turn: Int,
        cars: List<RacingCar>,
    ) {
        println("$turn 회 결과")
        cars.forEachIndexed { index, racingCar ->
            println("${index + 1} 자동차 현재위치는 ${racingCar.getCurrentPosition()} 입니다.")
        }
        println("----------------------------------------------------")
    }
}
