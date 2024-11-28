package racinggame

import racinggame.domain.Game
import racinggame.ui.InputView
import racinggame.ui.ResultView

fun main() {
    val input = InputView()
    val resultView = ResultView()

    val game = Game.createGame(input.carNames, input.gameTurn)
    game.onTurnCompleted = { currentTurn, cars ->
        if(currentTurn == 1) resultView.printInitialMessage()
        resultView.printResultOfTurn(currentTurn, cars)
    }

    game.startGame()
    resultView.printWinners(game.getResult())
}
