package calculator

fun main() {
    val customCalculator = Calculator()

    println("Type equation")
    val equation = readlnOrNull()

    val result = customCalculator.getResult(equation).toString()
    println("result: $result")
}
