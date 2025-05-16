package leetcode.leetcode_293_flip_game

/**
 * leetcode - https://leetcode.com/problems/flip-game/description/
 * Premium
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun generatePossibleNextMoves(currentState: String): List<String> {
    val result = mutableListOf<String>()
    for (i in 0..< currentState.lastIndex) {
        if (currentState[i] == '+' && currentState[i + 1] == '+') {
            result.add("${currentState.substring(0, i)}--${currentState.substring(i + 2)}")
        }
    }
    return result
}

private fun main() {

}
