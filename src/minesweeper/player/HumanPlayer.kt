package minesweeper.player

import minesweeper.logic.Board
import minesweeper.logic.Game
import minesweeper.logic.Player
import minesweeper.util.AnsiColor
import minesweeper.util.printAnsi
import java.util.*

class HumanPlayer(val input: Scanner) : Player {
    override fun doMove(game: Game) {
        try {
            game.write()
            val s = input.nextLine()
            if (s.toLowerCase().startsWith("flag ")) {
                game.flag(s[5].toInt() - 'A'.toInt(), s[6].toInt() - '0'.toInt())
                return
            }
            game.reveal(s[0].toInt() - 'A'.toInt(), s[1].toInt() - '0'.toInt())
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun onVictory(board: Board) {
        board.revealAll()
        board.write()
        printAnsi("Map solved", AnsiColor.GREEN)
    }

    override fun onDefeat(board: Board) {
        board.revealAll()
        board.write()
        printAnsi("You lose", AnsiColor.RED)
    }
}