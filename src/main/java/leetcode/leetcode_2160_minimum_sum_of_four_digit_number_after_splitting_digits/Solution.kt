package leetcode.leetcode_2160_minimum_sum_of_four_digit_number_after_splitting_digits

/**
 * leetcode - https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 *
 * Using sorting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 7 ms, faster than 100.00%
 * Memory Usage: 34.5 MB, less than 80.00%
 *
 * Time -
 * Space -
 */
private fun minimumSum(num: Int): Int {
    val nums = mutableListOf<Int>()
    var temp = num
    while (temp != 0) {
        nums.add(temp % 10)
        temp /= 10
    }
    nums.sort()
    return ((nums[0] + nums[1]) * 10) + (nums[2] + nums[3])
}

private fun main() {

}
