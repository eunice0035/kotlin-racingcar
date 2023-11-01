package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.util.Strings

object StringCalculator {
    private const val EMPTY_STRING = ""
    private const val FORMULA_REGEX = """^\s*\d+(\s*[+\-*/]\s*\d+)*\s*$"""

    fun calculate(input: String): Int {
        if (Strings.isNullOrEmpty(input)) throw IllegalArgumentException("입력값이 비어있습니다.")

        val tokens: List<String> = parseOperandAndOperator(input)

        return calculateFormula(tokens)
    }

    private fun calculateFormula(formulaTokens: List<String>): Int {
        var result = formulaTokens[0].toInt()
        formulaTokens.forEachIndexed { index, token ->
            run {
                if (index == 0) return@run

                if (isEvenNumber(index)) {
                    val operator = formulaTokens[index - 1]
                    result = OperatorType.calculate(operator, result, token.toInt())
                }
            }
        }

        return result
    }

    private fun parseOperandAndOperator(input: String): List<String> {
        val separatedTokens = input.split(EMPTY_STRING)

        val results = mutableListOf<String>()

        var number = EMPTY_STRING
        for (token in separatedTokens) {
            if (Strings.isNullOrEmpty(token) || token == " ") continue

            if (isNumber(token)) number += token
            if (isNumber(token).not() && number.isNotEmpty()) {
                results.add(number)
                number = EMPTY_STRING
            }
            if (isNumber(token).not()) results.add(token)
        }
        results.add(number)

        if (isValidFormulaOrder(input, results).not()) throw IllegalArgumentException("계산식이 올바르지 않습니다.")

        return results
    }

    private fun isValidFormulaOrder(input:String, parsedOperandAndOperator: MutableList<String>): Boolean {
        val regex = Regex(FORMULA_REGEX)

        return regex.matches(input) && parsedOperandAndOperator.size > 1
    }

    private fun isEvenNumber(num: Int) = num % 2 == 0

    private fun isNumber(str: String): Boolean {
        return try {
            str.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}