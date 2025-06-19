package leetcode.leetcode_2294_partition_array_such_that_maximum_difference_is_k

/**
 * leetcode - https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/?envType=daily-question&envId=2025-06-19
 *
 * Data Structure - [IntArray]
 * Algorithm - Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon
 */
private fun partitionArray(nums: IntArray, k: Int): Int {
    var result = 1
    val sortedNums = nums.sorted()
    var minValue = sortedNums[0]
    for (i in 1..sortedNums.lastIndex) {
        if (sortedNums[i] > minValue + k) {
            minValue = sortedNums[i]
            result++
        }
    }
    return result
}

private fun main() {

}
