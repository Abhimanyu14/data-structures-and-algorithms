package leetcode.leetcode_371_sum_of_two_integers

/**
 * leetcode - https://leetcode.com/problems/sum-of-two-integers/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Bitwise XOR and AND
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(1)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun getSum(a: Int, b: Int): Int {
    var result = a xor b
    var carry = (a and b) shl 1
    while (carry != 0) {
        val newResult = result xor carry
        carry = (result and carry) shl 1
        result = newResult
    }
    return result
}

private fun main() {

}
