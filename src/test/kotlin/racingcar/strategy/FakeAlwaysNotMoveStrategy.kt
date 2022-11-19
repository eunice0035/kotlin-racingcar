package racingcar.strategy

class FakeAlwaysNotMoveStrategy : MoveStrategy {
    override fun isPossibleMove(): Boolean = false

    override fun getDistance(): Int = 1
}