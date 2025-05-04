package leetcode.leetcode_1007_minimum_domino_rotations_for_equal_row

/**
 * leetcode - https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/?envType=daily-question&envId=2025-05-03
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [List]
 * Algorithm - Iteration and Counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2 * N)
 * Space - O(N)
 *
 * Companies - Google
 */
private fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
    fun check(candidate: Int): Int {
        var rotationsToMakeTopSame = 0
        var rotationsToMakeBottomSame = 0
        for (i in tops.indices) {
            if (tops[i] != candidate && bottoms[i] != candidate) {
                return -1
            }
            if (tops[i] != candidate) {
                rotationsToMakeTopSame++
            }
            if (bottoms[i] != candidate) {
                rotationsToMakeBottomSame++
            }
        }
        return minOf(rotationsToMakeTopSame, rotationsToMakeBottomSame)
    }

    val rotations = check(tops[0])
    if (rotations != -1) {
        return rotations
    }
    return check(bottoms[0])
}

private fun main() {
    println(minDominoRotations(intArrayOf(2, 1, 2, 4, 2, 2), intArrayOf(5, 2, 6, 2, 3, 2)))
    println(minDominoRotations(intArrayOf(3, 5, 1, 2, 3), intArrayOf(3, 6, 3, 3, 4)))
    println(minDominoRotations(intArrayOf(1, 2, 1, 1, 1, 2, 2, 2), intArrayOf(2, 1, 2, 2, 2, 2, 2, 2)))
}
