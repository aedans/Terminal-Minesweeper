package minesweeper.player

import minesweeper.logic.Board
import minesweeper.logic.Game
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

    Game(
            HumanPlayer(input),
            Board(x, y, bombs)
    ).run()
}
