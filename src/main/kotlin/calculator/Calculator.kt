package calculator

class Calculator {
    fun plusOperation(
        number1: Float,
        number2: Float,
    ): Float {
        return number1 + number2
    }

    fun minusOperation(
        number1: Float,
        number2: Float,
    ): Float {
        return number1 - number2
    }

    fun multipleOperation(
        number1: Float,
        number2: Float,
    ): Float {
        return number1 * number2
    }

    fun divideOperation(
        number1: Float,
        number2: Float,
    ): Float {
        if (number2.toInt() == 0) throw Exception("Not divided by 0")
        return number1 / number2
    }

    fun isOperator(input: String): Boolean {
        val operators = listOf("+", "-", "*", "/")
        return operators.any { it == input }
    }

    fun splitEquation(equation: String): List<String> {
        val regex = OPERATION_REGEX.toRegex()
        return regex.findAll(equation).map { it.value }.toList()
    }

    fun getResult(equation: String?): Float {
        if (equation.isNullOrEmpty()) throw IllegalArgumentException()

        val itemList = splitEquation(equation)
        if (itemList.size < 3) throw Exception("Invalid equation")

        var firstNumber: Float = itemList[0].toFloat()
        var secondNumber: Float
        var operator = ""

        for (i in 1 until itemList.size) {
            if (isOperator(itemList[i])) {
                operator = itemList[i]
                continue
            }
            secondNumber = itemList[i].toFloat()
            firstNumber =
                when (operator) {
                    "+" -> plusOperation(firstNumber, secondNumber)
                    "-" -> minusOperation(firstNumber, secondNumber)
                    "*" -> multipleOperation(firstNumber, secondNumber)
                    "/" -> divideOperation(firstNumber, secondNumber)
                    else -> throw Exception("Invalid operation")
                }
        }
        return firstNumber
    }

    companion object {
        const val OPERATION_REGEX = "\\d+|[+\\-*/]"
    }
}
