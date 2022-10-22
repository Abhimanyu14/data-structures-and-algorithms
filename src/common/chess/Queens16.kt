package common.chess

/**
 * WIP
 */
fun printBoard(
    board: Array<IntArray>,
) {
    println()
    board.forEachIndexed { row, ints ->
        ints.forEachIndexed { col, i ->
            print("($row,$col) : $i     ")
        }
        println()
    }
    println()
}

fun main() {
    val x = 1..2
    val y = 1.0..5.0
    val z = 1 until 5
    val emptyBoard: Array<IntArray> = Array(8) { IntArray(8) { 0 } }
    printBoard(emptyBoard)
}
