package ui

class InputView {

    val carNumber: Int by lazy {
        println("자동차 대수는 몇 대인가요?")
        val input = readln()
        checkValidInput(input)
        input.toInt()
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