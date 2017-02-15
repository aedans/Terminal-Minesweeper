package minesweeper.player

import minesweeper.logic.Board
import minesweeper.util.AnsiColor
import minesweeper.util.printAnsi

/**
 * Created by Aedan Smith.
 */

fun Board.write() {
    printAnsi("# ", AnsiColor.YELLOW)
    for (i in 0..this.xSize-1){ printAnsi((i + 'A'.toInt()).toChar() + " ", AnsiColor.YELLOW) }
    this.contents.forEachIndexed { i, tiles ->
        println()
        printAnsi((i + '0'.toInt()).toChar().toString(), AnsiColor.YELLOW)
        tiles.forEach {
            if (it.isRevealed){
                if (it.isBomb) {
                    printAnsi(" *", AnsiColor.RED)
                } else {
                    printAnsi(" " + it.surrounding, when(it.surrounding) {
                        0 -> AnsiColor.WHITE
                        1 -> AnsiColor.GREEN
                        2 -> AnsiColor.CYAN
                        3 -> AnsiColor.BLUE
                        4 -> AnsiColor.PURPLE
                        5 -> AnsiColor.YELLOW
                        else -> AnsiColor.RED
                    })
                }
            } else {
                if (it.isFlagged) {
                    printAnsi(" _", AnsiColor.RED)
                } else {
                    printAnsi(" _", AnsiColor.WHITE)
                }
            }
        }
    }
    println()
}
