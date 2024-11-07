package leetcode.leetcode_2023_number_of_pairs_of_strings_with_concatenation_equal_to_target

/**
 * leetcode - https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 277 ms, faster than 50.00%
 * Memory Usage: 39 MB, less than 50.00%
 */
private fun numOfPairs(nums: Array<String>, target: String): Int {
    var result = 0
    repeat (nums.size) { i ->
        repeat(nums.size) { j ->
            if (i != j && (nums[i] + nums[j] == target)) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
