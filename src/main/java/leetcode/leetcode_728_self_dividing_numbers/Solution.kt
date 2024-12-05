package leetcode.leetcode_728_self_dividing_numbers

/**
 * leetcode - https://leetcode.com/problems/self-dividing-numbers/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction and Modulo
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 35 MB, less than 50.00%
 *
 * Time - O(N log(N))
 * Space - O(1)
 */
private fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    fun isSelfDividing(n: Int): Boolean {
        var temp = n
        while (temp != 0) {
            if (temp % 10 == 0 || n % (temp % 10) != 0) {
                return false
            }
            temp /= 10
        }
        return true
    }
    val result = mutableListOf<Int>()
    for (i in left..right) {
        if (isSelfDividing(i)) {
            result.add(i)
        }
    }
    return result
}

private fun main() {

}
