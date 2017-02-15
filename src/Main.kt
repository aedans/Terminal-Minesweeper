import minesweeper.AnsiColor
import minesweeper.Board
import minesweeper.printAnsi
import minesweeper.render
import java.util.*

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    System.out.print("Width: ")
    val x = input.nextLine().toInt()
    System.out.print("Height: ")
    val y = input.nextLine().toInt()
    System.out.print("Bombs: ")
    val bombs = input.nextLine().toInt()
    println()
    val board = Board(x, y, bombs)
    while (true) {
        try {
            board.render()
            val s = input.nextLine()
            if (s.toLowerCase().startsWith("flag ")) {
                board.get(s[5].toInt() - 'A'.toInt(), s[6].toInt() - '0'.toInt())?.isFlagged = true
                continue
            }
            board.reveal(s[0].toInt() - 'A'.toInt(), s[1].toInt() - '0'.toInt())
            if (board.isComplete()) {
                break
            }
        } catch (e: Exception){
            e.printStackTrace()
            continue
        }
    }
    board.revealAll()
    board.render()
    printAnsi("Map solved", AnsiColor.GREEN)
}
