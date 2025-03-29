package leetcode.leetcode_266_palindrome_permutation

/**
 * leetcode - https://leetcode.com/problems/palindrome-permutation/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [Array]
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun canPermutePalindrome(s: String): Boolean {
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
    return oddCount <= 1
}
private fun main() {

}
