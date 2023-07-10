package leetcode.leet_1800_to_1899.leet_1823_find_the_winner_of_the_circular_game

/**
 * Stats
 * Runtime: 251 ms, faster than 20.00%
 * Memory Usage: 36.6 MB, less than 20.00%
 */
fun findTheWinner(n: Int, k: Int): Int {
    var pos = 0
    val list = IntArray(n) { it + 1 }.toMutableList()
    while (list.size > 1) {
        pos = (pos + k - 1) % list.size
        list.removeAt(pos)
    }
    return list.first()
}

private fun main() {
    println(findTheWinner(5, 2))
    println(findTheWinner(6, 5))
}
