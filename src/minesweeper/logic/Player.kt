package minesweeper.logic

/**
 * Created by Aedan Smith.
 */

interface Player {
    fun doMove(game: Game)
    fun onVictory(board: Board)
    fun onDefeat(board: Board)
}
