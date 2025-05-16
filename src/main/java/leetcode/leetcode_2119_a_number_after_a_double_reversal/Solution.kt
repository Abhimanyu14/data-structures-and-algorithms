package leetcode.leetcode_2119_a_number_after_a_double_reversal

/**
 * leetcode - https://leetcode.com/problems/a-number-after-a-double-reversal/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * Data Structure - NA
 * Algorithm - Maths
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(1)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun isSameAfterReversals(num: Int): Boolean {
    if (num == 0) {
        return true
    }
    if (num % 10 == 0) {
        return false
    }
    return true
}

private fun main() {

}
