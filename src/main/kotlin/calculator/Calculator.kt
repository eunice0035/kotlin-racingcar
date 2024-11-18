package calculator

class Calculator {
    fun isOperator(input: String) {
        try {
            OPERATOR.fromSymbol(input)
        } catch (e: IllegalArgumentException) {
            e.toString()
        }
    }

    fun getOperatorFromEquation(equation: String): List<String> {
        val regex = OPERATOR_REGEX.toRegex()
        return regex.findAll(equation).map { it.value }.toList()
    }

    fun getNumbersFromEquation(equation: String): List<Float> {
        val regex = NUMBER_REGEX.toRegex()
        return regex.findAll(equation).map { it.value.toFloat() }.toList()
    }

    fun checkIsValidEquation(equation: String) {
        require(equation.isNotEmpty()) {
            "Equation is Empty."
        }
    }

    fun getResult(equation: String): Float {
        val numbers = getNumbersFromEquation(equation)
        val operators = getOperatorFromEquation(equation)

        if (numbers.size < 2 || operators.isEmpty()) throw Exception("Invalid equation")

        val finalResult = numbers.drop(1).foldIndexed(numbers.first()) { index, result, operand ->
            isOperator(operators[index])
            when (OPERATOR.fromSymbol(operators[index])) {
                OPERATOR.PLUS -> OPERATOR.PLUS.calculate(result, operand)
                OPERATOR.MINUS -> OPERATOR.MINUS.calculate(result, operand)
                OPERATOR.MULTIPLE -> OPERATOR.MULTIPLE.calculate(result, operand)
                OPERATOR.DIVIDE -> OPERATOR.DIVIDE.calculate(result, operand)
            }
        }

        return finalResult
    }

    companion object {
        private const val OPERATOR_REGEX = "[+\\-*/]"
        private const val NUMBER_REGEX = "\\d+"


        enum class OPERATOR(val symbol: String) {
            PLUS("+") {
                override fun calculate(
                    number1: Float,
                    number2: Float,
                ): Float = number1 + number2
            },
            MINUS("-") {
                override fun calculate(
                    number1: Float,
                    number2: Float,
                ): Float = number1 - number2
            },
            MULTIPLE("*") {
                override fun calculate(
                    number1: Float,
                    number2: Float,
                ): Float = number1 * number2
            },
            DIVIDE("/") {
                override fun calculate(
                    number1: Float,
                    number2: Float,
                ): Float {
                    if (number2.toInt() == 0) throw Exception("Not divided by 0")
                    return number1 / number2
                }
            };

            abstract fun calculate(number1:Float, number2: Float): Float

            companion object {
                fun fromSymbol(symbol: String): OPERATOR {
                    return entries.find { it.symbol == symbol }
                        ?: throw IllegalArgumentException("Unknown Operation")
                }
            }
        }
    }
}
