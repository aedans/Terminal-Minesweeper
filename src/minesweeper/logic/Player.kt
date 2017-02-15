package minesweeper.logic

/**
 * Created by Aedan Smith.
 */

interface Player {
    fun doMove(game: MinesweeperGame)
    fun onVictory(board: Board)
    fun onDefeat(board: Board)
}
