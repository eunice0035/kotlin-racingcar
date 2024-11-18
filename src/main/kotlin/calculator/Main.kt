package calculator

fun main() {
    val customCalculator = Calculator()

    println("Type equation")
    val equation = readln()

    customCalculator.checkIsValidEquation(equation)
    val result = customCalculator.getResult(equation).toString()
    println("result: $result")
}
