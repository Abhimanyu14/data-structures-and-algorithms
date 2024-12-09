package leetcode.leetcode_3152_special_array_ii

/**
 * leetcode - https://leetcode.com/problems/special-array-ii/
 *
 * Data Structure - Array
 * Algorithm - Iteration and Preprocessing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 20 ms, faster than 50.00%
 * Memory Usage: 124.7 MB, less than 33.33%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
    val result = BooleanArray(queries.size)
    val previousSameParityIndex = IntArray(nums.size) { -1 }
    for (i in 1..nums.lastIndex) {
        previousSameParityIndex[i] = if (nums[i] % 2 == nums[i - 1] % 2) {
            i - 1
        } else {
            previousSameParityIndex[i - 1]
        }
    }
    for (i in queries.indices) {
        result[i] = queries[i][0] > previousSameParityIndex[queries[i][1]]
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/special-array-ii/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * nums.size - N
 * queries.size - M
 * Time - O(M * N)
 * Space - O(1)
 */
private fun isArraySpecialUsingBruteForce(nums: IntArray, queries: Array<IntArray>): BooleanArray {
    val result = BooleanArray(queries.size) { true }
    var isEven: Boolean
    for (i in queries.indices) {
        isEven = nums[queries[i][0]] % 2 == 0
        for (j in (queries[i][0] + 1)..queries[i][1]) {
            if ((nums[j] % 2 == 0 && isEven) || (nums[j] % 2 != 0 && !isEven)) {
                result[i] = false
                break
            }
            isEven = !isEven
        }
    }
    return result
}

private fun main() {

}
