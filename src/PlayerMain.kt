import minesweeper.logic.Board
import minesweeper.logic.MinesweeperGame
import minesweeper.logic.Player
import minesweeper.util.AnsiColor
import minesweeper.util.printAnsi
import minesweeper.write
import java.util.*

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>){
    val input = Scanner(System.`in`)
    System.out.print("Width: ")
    val x = input.nextLine().toInt()
    System.out.print("Height: ")
    val y = input.nextLine().toInt()
    System.out.print("Bombs: ")
    val bombs = input.nextLine().toInt()
    println()

    MinesweeperGame(
            HumanPlayer(input),
            Board(x, y, bombs)
    ).run()
}

class HumanPlayer(val input: Scanner) : Player {
    override fun doMove(game: MinesweeperGame) {
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

