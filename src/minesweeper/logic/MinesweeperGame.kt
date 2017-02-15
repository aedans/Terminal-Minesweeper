package minesweeper.logic

import minesweeper.write

/**
 * Created by Aedan Smith.
 */

class MinesweeperGame(val player: Player, private val board: Board): Runnable {
    var isAlive = false

    override fun run() {
        isAlive = true
        board.init()
        while (isAlive) {
            if (board.isComplete()) {
                player.onVictory(board)
                return
            }
            player.doMove(this)
        }
    }

    fun get(x: Int, y: Int) = board.get(x, y)

    fun reveal(x: Int, y: Int) {
        if (board.reveal(x, y)) {
            player.onDefeat(board)
            isAlive = false
        }
    }

    fun write() = board.write()
}
