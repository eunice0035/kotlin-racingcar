package racingcar.io

import racingcar.utils.splitByComma

object InputView {
    fun getParticipateCarNames(): List<ParticipateCarName> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)")
        val cars = readln().splitByComma()
        return cars.map { ParticipateCarName(it) }
    }

    fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}