package leetcode.leetcode_2554_maximum_number_of_integers_to_choose_from_a_range_i

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/?envType=daily-question&envId=2024-12-06
 *
 * Data Structure - Set
 * Algorithm - Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 67 ms, faster than 80.00%
 * Memory Usage: 48.4 MB, less than 30.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
    var result = 0
    var currentSum = 0
    val bannedSet = banned.toSet()
    for (i in 1..n) {
        if (currentSum + i > maxSum) {
            break
        }
        if (i !in bannedSet) {
            result++
            currentSum += i
        }
    }
    return result
}

private fun main() {

}
