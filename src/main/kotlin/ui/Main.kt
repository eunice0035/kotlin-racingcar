package ui

import domain.Game

fun main() {

    val input = InputView()
    val game = Game()
    val resultView = ResultView()

    game.makingCar(input.carNumber, input.gameTurn)

    println("\n실행 결과")
    for (i in 0 until input.gameTurn) {
        game.movingAllCar()
        resultView.printResult(i + 1, game.carList)
    }
}
