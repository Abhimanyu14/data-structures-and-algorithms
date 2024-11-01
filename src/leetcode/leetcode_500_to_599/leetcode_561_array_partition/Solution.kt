package leetcode.leetcode_500_to_599.leetcode_561_array_partition

/**
 * leetcode - https://leetcode.com/problems/array-partition/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 408 ms, faster than 29.73%
 * Memory Usage: 42.8 MB, less than 51.35%
 */
private fun arrayPairSum(nums: IntArray): Int {
    var result = 0
    val sortedList = nums.sorted()
    for (i in 0..sortedList.lastIndex step 2) {
        result += sortedList[i]
    }
    return result
}

private fun main() {

}
