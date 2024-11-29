package racinggame.ui

class InputView {
    val carNames: String by lazy {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readln()
        checkValidInput(input)
        input
    }
    val gameTurn: Int by lazy {
        println("시도할 횟수는 몇 회인가요?")
        val input = readln()
        checkValidInput(input)
        input.toInt()
    }

    fun checkValidInput(input: String) {
        require(input.isNotEmpty())
    }
}