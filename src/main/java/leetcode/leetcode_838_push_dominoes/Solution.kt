package leetcode.leetcode_838_push_dominoes

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/push-dominoes/description/?envType=daily-question&envId=2025-05-02
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun pushDominoes(dominoes: String): String {
    val result = StringBuilder()
    val dominoesCharArray = dominoes.toCharArray()
    val forces = IntArray(dominoesCharArray.size)

    // Populate forces going from left to right
    var force = 0
    for (i in dominoesCharArray.indices) {
        force = if (dominoesCharArray[i] == 'R') {
            dominoesCharArray.size
        } else if (dominoesCharArray[i] == 'L') {
            0
        } else {
            max(force - 1, 0)
        }
        forces[i] += force
    }

    // Populate forces going from right to left
    force = 0
    for (i in dominoesCharArray.size - 1 downTo 0) {
        force = if (dominoesCharArray[i] == 'L') {
            dominoesCharArray.size
        } else if (dominoesCharArray[i] == 'R') {
            0
        } else {
            max(force - 1, 0)
        }
        forces[i] -= force
    }

    for (f in forces) {
        result.append(
            if (f > 0) {
                'R'
            } else if (f < 0) {
                'L'
            } else {
                '.'
            }
        )
    }
    return result.toString()
}

private fun main() {

}
