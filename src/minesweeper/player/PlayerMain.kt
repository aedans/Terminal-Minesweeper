package minesweeper.player

import minesweeper.logic.Board
import minesweeper.logic.MinesweeperGame
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
