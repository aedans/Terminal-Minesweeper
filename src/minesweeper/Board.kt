package minesweeper

import java.util.*

/**
 * Created by Aedan Smith.
 */

class Board(val xSize: Int = 15, val ySize: Int = 15, numBombs: Int = 30){
    val contents = Array(ySize) { y -> Array(xSize) { x -> Tile(x, y) } }

    init {
        (0..numBombs-1).forEach { get(Random().nextInt(xSize), Random().nextInt(ySize))?.isBomb = true }
        contents.forEachIndexed { y, tiles -> tiles.forEachIndexed { x, tile ->
            var surrounding = 0
            surrounding(x, y).forEach {
                if (it != null && it.isBomb)
                    surrounding++
            }
            tile.surrounding = surrounding
        } }
    }

    fun reveal(x: Int, y: Int) {
        val tile = get(x, y) ?: throw RuntimeException("Invalid position ($x, $y)")
        if (tile.isBomb) {
            revealAll()
            render()
            printAnsi("You lose", AnsiColor.RED)
            System.exit(0)
        }
        if (!tile.isRevealed) tile.isRevealed = true else throw RuntimeException("Already revealed ($x, $y)")
        if (tile.surrounding == 0) {
            surrounding(x, y).filterNotNull().forEach {
                if (!it.isRevealed && !it.isBomb) {
                    if (it.surrounding == 0) {
                        reveal(it.x, it.y)
                    } else {
                        it.isRevealed = true
                    }
                }
            }
        }
    }

    fun revealAll() = contents.forEach { it.forEach { it.isRevealed = true } }

    fun isComplete(): Boolean {
        contents.forEach { it.forEach {
            if (!it.isRevealed && !it.isBomb)
                return false
        } }
        return true
    }

    fun surrounding(x: Int, y: Int): Array<Tile?> = arrayOf(
            get(x+1, y),
            get(x-1, y),
            get(x, y+1),
            get(x, y-1),
            get(x+1, y+1),
            get(x-1, y-1),
            get(x-1, y+1),
            get(x+1, y-1)
    )

    fun get(x: Int, y: Int): Tile? {
        if (x >= xSize || x < 0 || y >= ySize || y < 0)
            return null
        return contents[y][x]
    }
}
