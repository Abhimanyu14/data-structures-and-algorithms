package leetcode.leetcode_3477_fruits_into_baskets_ii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/fruits-into-baskets-ii/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Segment Tree
 * Algorithm - Segment Tree
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(M)
 *
 * Companies - Microsoft
 */
private class SegmentTreeNode(
    var value: Int,
    val start: Int,
    val end: Int,
    var left: SegmentTreeNode? = null,
    var right: SegmentTreeNode? = null,
)

private fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
    var result = fruits.size
    if (baskets.isEmpty()) {
        return result
    }
    fun buildSegmentTree(start: Int, end: Int): SegmentTreeNode {
        if (start == end) {
            return SegmentTreeNode(
                baskets[start],
                start,
                end,
            )
        }
        val left = buildSegmentTree(start, start + ((end - start) / 2))
        val right = buildSegmentTree(start + ((end - start) / 2) + 1, end)
        return SegmentTreeNode(
            max(left.value, right.value),
            start,
            end,
            left,
            right
        )
    }

    val segmentTreeRoot = buildSegmentTree(0, baskets.lastIndex)

    fun updateSegmentTree(current: SegmentTreeNode, fruit: Int): SegmentTreeNode {
        if (current.left != null && current.left?.value!! >= fruit) {
            val left = updateSegmentTree(current.left!!, fruit)
            current.value = max(current.right?.value ?: 0, left.value)
        } else if (current.right != null && current.right?.value!! >= fruit) {
            val right = updateSegmentTree(current.right!!, fruit)
            current.value = max(current.left?.value ?: 0, right.value)
        } else {
            current.value = 0
        }
        return current
    }

    for (i in fruits.indices) {
        if (segmentTreeRoot.value >= fruits[i]) {
            result--
            updateSegmentTree(segmentTreeRoot, fruits[i])
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/fruits-into-baskets-ii/description/
 *
 * Data Structure - Segment Tree
 * Algorithm - Hashing, Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N * M)
 * Space - O(M)
 *
 * Companies - Microsoft
 */
private fun numOfUnplacedFruitsUsingSet(fruits: IntArray, baskets: IntArray): Int {
    var result = fruits.size
    val used = mutableSetOf<Int>()
    for (fruit in fruits) {
        for (i in baskets.indices) {
            if (!used.contains(i) && fruit <= baskets[i]) {
                result--
                used.add(i)
                break
            }
        }
    }
    return result
}

private fun main() {

}
