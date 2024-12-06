package leetcode.leetcode_2553_separate_the_digits_in_an_array

/**
 * leetcode - https://leetcode.com/problems/separate-the-digits-in-an-array/
 *
 * Data Structure - List
 * Algorithm - Digits Extraction and [reversed]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 19 ms, faster than 37.50%
 * Memory Usage: 39.8 MB, less than 12.50%
 *
 * Time - O(N log(N))
 * Space - O(N log(N))
 */
private fun separateDigits(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()
    fun getDigits(x: Int): List<Int> {
        val digits = mutableListOf<Int>()
        var temp = x
        while (temp != 0) {
            digits.add(temp % 10)
            temp /= 10
        }
        return digits.reversed()
    }
    for (num in nums) {
        result.addAll(getDigits(num))
    }
    return result.toIntArray()
}

private fun main() {

}
