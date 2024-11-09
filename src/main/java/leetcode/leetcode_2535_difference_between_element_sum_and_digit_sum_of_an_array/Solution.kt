package leetcode.leetcode_2535_difference_between_element_sum_and_digit_sum_of_an_array

/**
 * leetcode - https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 100.00%
 * Memory Usage: 38.9 MB, less than 68.42%
 *
 * Time -
 * Space -
 */
private fun differenceOfSum(nums: IntArray): Int {
    var result = 0
    nums.forEach {
        if (it >= 10) {
            var temp = it
            var currentSum = 0
            while (temp != 0) {
                currentSum += temp % 10
                temp /= 10
            }
            result += (it - currentSum)
        }
    }
    return result
}

private fun main() {

}
