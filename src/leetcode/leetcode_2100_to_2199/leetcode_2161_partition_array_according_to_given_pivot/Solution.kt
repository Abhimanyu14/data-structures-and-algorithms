package leetcode.leetcode_2100_to_2199.leetcode_2161_partition_array_according_to_given_pivot

/**
 * leetcode - https://leetcode.com/problems/partition-array-according-to-given-pivot/
 *
 * Using additional lists
 *
 * Stats
 * Runtime: 912 ms, faster than 75.00%
 * Memory Usage: 59.4 MB, less than 70.00%
 */
private fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    var pivotCount = 0
    nums.forEach {
        if (it == pivot) {
            pivotCount++
        } else if (it < pivot) {
            left.add(it)
        } else {
            right.add(it)
        }
    }
    left.addAll(MutableList(pivotCount) { pivot })
    left.addAll(right)
    return left.toIntArray()
}

private fun main() {
    println(pivotArray(intArrayOf(9, 12, 5, 10, 14, 3, 10), 10).joinToString(", "))
}
