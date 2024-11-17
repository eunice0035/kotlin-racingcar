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
        return try {
            OPERATOR.fromSymbol(input)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun splitEquation(equation: String): List<String> {
        val regex = OPERATION_REGEX.toRegex()
        return regex.findAll(equation).map { it.value }.toList()
    }

    fun checkIsValidEquation(equation: String) {
        require(equation.isNotEmpty()) {
            "Equation is Empty."
        }
    }

    fun getResult(equation: String): Float {
        val itemList = splitEquation(equation)
        println(itemList)
        if (itemList.size < 3) throw Exception("Invalid equation")

        var result: Float = itemList[0].toFloat()
        var operand: Float
        var operator = ""

        for (i in 1 until itemList.size) {
            println(i)
            println(itemList[i])
            println(isOperator(itemList[i]))
            if (isOperator(itemList[i])) {
                operator = itemList[i]
                continue
            }
            println(i)
            operand = itemList[i].toFloat()
            result = when (OPERATOR.fromSymbol(operator)) {
                OPERATOR.PLUS -> plusOperation(result, operand)
                OPERATOR.MINUS -> minusOperation(result, operand)
                OPERATOR.MULTIPLE -> multipleOperation(result, operand)
                OPERATOR.DIVIDE -> divideOperation(result, operand)
            }

        }
        return result
    }

    companion object {
        private const val OPERATION_REGEX = "\\d+|[+\\-*/]"

        enum class OPERATOR(val symbol: String) {
            PLUS("+"),
            MINUS("-"),
            MULTIPLE("*"),
            DIVIDE("/");

            companion object {
                fun fromSymbol(symbol: String): OPERATOR {
                    return entries.find { it.symbol == symbol }
                        ?: throw IllegalArgumentException("Unknown Operation")
                }
            }
        }
    }
}
