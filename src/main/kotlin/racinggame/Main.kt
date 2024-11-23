package racinggame

import racinggame.domain.Game
import racinggame.domain.GameParameter
import racinggame.ui.InputView
import racinggame.ui.ResultView

fun main() {
    val input = InputView()
    val resultView = ResultView()

    val gameParameterMaker = GameParameter()
    val game = Game(gameParameterMaker.createCars(input.carNumber), input.gameTurn)

    println("\n실행 결과")
    var turnNumber = 1
    while(game.startTurn()) {
        resultView.printResult(turnNumber, game.cars)
        turnNumber++
    }
}
