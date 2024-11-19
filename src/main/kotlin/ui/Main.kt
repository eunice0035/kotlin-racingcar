package ui

import racinggame.domain.Game

fun main() {
    val input = InputView()
    val resultView = ResultView()

    val game =
        Game(
            carNumber = input.carNumber,
            initMoving = input.gameTurn,
        )

    println("\n실행 결과")
    for (i in 1..game.totalGameTurn) {
        game.startTurn()
        resultView.printResult(i, game.cars)
    }
}
