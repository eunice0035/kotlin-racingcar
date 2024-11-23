package racinggame

import racinggame.domain.Game
import racinggame.ui.InputView
import racinggame.ui.ResultView

fun main() {
    val input = InputView()
    val resultView = ResultView()

    val game = Game(carNumber = input.carNumber, initMoving = input.gameTurn)

    println("\n실행 결과")
    for (i in 1..game.totalGameTurn) {
        game.startTurn()
        resultView.printResult(i, game.cars)
    }
}
