package study.racinggame.ui

import study.racinggame.domain.RacingGameStage

object CommandLineRacingGameStagePrinter {
    fun print(racingGameStage: RacingGameStage) {
        racingGameStage.positionOfCars.forEach { HyphenCarPositionPrinter.print(it) }
        println()
    }
}
