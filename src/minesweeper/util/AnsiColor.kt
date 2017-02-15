package minesweeper.util

import java.io.PrintStream

/**
 * Created by Aedan Smith.
 */

enum class AnsiColor(val escape: String) {
    BLACK("[30m"),
    RED("[31m"),
    GREEN("[32m"),
    YELLOW("[33m"),
    BLUE("[34m"),
    PURPLE("[35m"),
    CYAN("[36m"),
    WHITE("[37m")
}

fun printAnsi(s: String, color: AnsiColor, out: PrintStream = System.out) = out.print("\u001b${color.escape}$s")
