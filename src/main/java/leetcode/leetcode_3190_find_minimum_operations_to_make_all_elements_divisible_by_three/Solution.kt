package leetcode.leetcode_3190_find_minimum_operations_to_make_all_elements_divisible_by_three

/**
 * leetcode - https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/
 *
 * Using [count]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 35.3 MB, less than 25.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun minimumOperations(nums: IntArray): Int {
    return nums.count {
        it % 3 != 0
    }
}

private fun main() {

}
