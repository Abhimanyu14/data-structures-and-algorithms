package leetcode.leetcode_2997_minimum_number_of_operations_to_make_array_xor_equal_to_k

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/solution/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minOperations(nums: IntArray, k: Int): Int {
    var finalXor = 0
    for (n in nums) {
        finalXor = finalXor xor n
    }
    return Integer.bitCount(finalXor xor k)
}

private fun main() {

}
