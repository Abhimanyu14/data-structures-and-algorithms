package leetcode.leetcode_2859_sum_of_values_at_indices_with_k_set_bits

/**
 * leetcode - https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
 *
 * Using [countOneBits]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 3 ms, faster than 66.67%
 * Memory Usage: 40.2 MB, less than 26.67%
 *
 * Time -
 * Space -
 */
private fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int {
    var result = 0
    nums.forEachIndexed { index, num ->
        if (index.countOneBits() == k) {
            result += num
        }
    }
    return result
}

private fun main() {

}
