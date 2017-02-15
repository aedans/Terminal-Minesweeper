package minesweeper.logic

/**
 * Created by Aedan Smith.
 */

data class Tile(val x: Int, val y: Int, var isRevealed: Boolean = false, var isBomb: Boolean = false, var isFlagged: Boolean = false) {
    var surrounding = 0
}
