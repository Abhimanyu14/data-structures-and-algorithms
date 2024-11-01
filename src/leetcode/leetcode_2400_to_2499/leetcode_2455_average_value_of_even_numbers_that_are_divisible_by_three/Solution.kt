package leetcode.leetcode_2400_to_2499.leetcode_2455_average_value_of_even_numbers_that_are_divisible_by_three

/**
 * leetcode - https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 179 ms, faster than 87.50%
 * Memory Usage: 37.4 MB, less than 75.00%
 */
private fun averageValue(nums: IntArray): Int {
    var sum = 0
    var count = 0
    nums.forEach {
        if (it % 6 == 0) {
            sum += it
            count++
        }
    }
    if (count == 0) {
        return 0
    }
    return sum / count
}

private fun main() {

}
