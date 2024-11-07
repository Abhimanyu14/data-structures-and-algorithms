package leetcode.leetcode_1007_minimum_domino_rotations_for_equal_row

import kotlin.math.min

/**
 * leetcode -
 *
 * Using set, list, iterator, count(),
 *
 * Stats
 * Runtime: 476 ms, faster than 85.71%
 * Memory Usage: 47.5 MB, less than 71.43%
 */
private fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
    val commonNumbers = setOf(tops[0], bottoms[0]).toMutableList()
    for (i in 1..tops.lastIndex) {
        val iterator = commonNumbers.listIterator()
        while (iterator.hasNext()) {
            val temp = iterator.next()
            if (!(temp == tops[i] || temp == bottoms[i])) {
                iterator.remove()
            }
        }
        if (commonNumbers.isEmpty()) {
            return -1
        }
    }
    if (commonNumbers.size == 2) {
        val count = tops.count { it == commonNumbers[0] }
        return min(count, tops.size - count)
    }
    val topCount = tops.count { it != commonNumbers[0] }
    val bottomCount = bottoms.count { it != commonNumbers[0] }
    return min(topCount, bottomCount)
}

private fun main() {
    println(minDominoRotations(intArrayOf(2, 1, 2, 4, 2, 2), intArrayOf(5, 2, 6, 2, 3, 2)))
    println(minDominoRotations(intArrayOf(3, 5, 1, 2, 3), intArrayOf(3, 6, 3, 3, 4)))
    println(minDominoRotations(intArrayOf(1, 2, 1, 1, 1, 2, 2, 2), intArrayOf(2, 1, 2, 2, 2, 2, 2, 2)))
}
