package leetcode.leetcode_1400_construct_k_palindrome_strings

/**
 * leetcode - https://leetcode.com/problems/construct-k-palindrome-strings/description/?envType=daily-question&envId=2025-01-11
 *
 * Data Structure - Array
 * Algorithm - Counting and Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun canConstruct(s: String, k: Int): Boolean {
    val counter = IntArray(26)
    for (char in s) {
        counter[char - 'a']++
    }
    var oddCount = 0
    for (i in 0..25) {
        if (counter[i] % 2 == 1) {
            oddCount++
        }
    }
    return k >= oddCount && k <= s.length
}

private fun main() {

}
