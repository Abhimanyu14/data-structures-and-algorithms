package leetcode.leetcode_3289_the_two_sneaky_numbers_of_digitville

/**
 * leetcode - https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
 *
 * Using set
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 11 ms, faster than 53.33%
 * Memory Usage: 39.1 MB, less than 35.88%
 *
 * Time -
 * Space -
 */
private fun getSneakyNumbers(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val set = mutableSetOf<Int>()
    nums.forEach {
        if (set.contains(it)) {
            result.add(it)
        } else {
            set.add(it)
        }
    }
    return result.toIntArray()
}

private fun main() {

}
