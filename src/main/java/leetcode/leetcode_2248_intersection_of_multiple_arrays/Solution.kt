package leetcode.leetcode_2248_intersection_of_multiple_arrays

/**
 * leetcode - https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Using
 *
 * Stats
 * Runtime: 431 ms, faster than 36.36%
 * Memory Usage: 46.7 MB, less than 27.27%
 */
private fun intersection(nums: Array<IntArray>): List<Int> {
    var result = nums[0].toSet()
    for (i in 1..nums.lastIndex) {
        result = result intersect nums[i].toSet()
    }
    return result.toList().sorted()
}

private fun main() {
    println(
        intersection(
            arrayOf(
                intArrayOf(3, 1, 2, 4, 5),
                intArrayOf(1, 2, 3, 4),
                intArrayOf(3, 4, 5, 6),
            )
        ).joinToString()
    )
    println(
        intersection(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
            )
        ).joinToString()
    )
}
