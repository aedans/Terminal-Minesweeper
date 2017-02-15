package minesweeper

/**
 * Created by Aedan Smith.
 */

data class Tile(val x: Int, val y: Int, var isRevealed: Boolean = false, var isBomb: Boolean = false) {
    var surrounding = 0
    var isFlagged = false
}
