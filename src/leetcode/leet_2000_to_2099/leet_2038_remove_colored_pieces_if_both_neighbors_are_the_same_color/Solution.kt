package leetcode.leet_2000_to_2099.leet_2038_remove_colored_pieces_if_both_neighbors_are_the_same_color

/**
 * leetcode - https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 *
 * Using loop
 *
 * Stats
 * Runtime: 222 ms, faster than 85.71%
 * Memory Usage: 39.3 MB, less than 28.57%
 */
private fun winnerOfGame(colors: String): Boolean {
    if (colors.length <= 2) {
        return false
    }
    var count = 0
    for (i in 1..(colors.lastIndex - 1)) {
        if (colors[i - 1] == 'A' && colors[i] == 'A' && colors[i + 1] == 'A') {
            count++
        } else if (colors[i - 1] == 'B' && colors[i] == 'B' && colors[i + 1] == 'B') {
            count--
        }
    }
    return count > 0
}

private fun main() {

}
