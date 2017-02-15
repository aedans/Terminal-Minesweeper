package minesweeper.logic

import minesweeper.player.write

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

    fun getSurrounding(x: Int, y: Int) = board.get(x, y)!!.surrounding
    fun isRevealed(x: Int, y: Int) = board.get(x, y)!!.isRevealed
    fun flag(x: Int, y: Int) { board.get(x, y)!!.isFlagged = true }

    fun reveal(x: Int, y: Int) {
        if (board.reveal(x, y)) {
            player.onDefeat(board)
            isAlive = false
        }
    }

    fun write() = board.write()
}
