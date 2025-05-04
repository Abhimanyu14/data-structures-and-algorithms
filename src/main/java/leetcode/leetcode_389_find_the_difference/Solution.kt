package leetcode.leetcode_389_find_the_difference

/**
 * leetcode - https://leetcode.com/problems/find-the-difference/
 *
 * Data Structure - [IntArray]
 * Algorithm - Bitwise operator - XOR
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun findTheDifference(s: String, t: String): Char {
    var result = t.last() - 'a'
    for (i in s.indices) {
        result = result xor (s[i] - 'a')
        result = result xor (t[i] - 'a')
    }
    return 'a' + result
}

/**
 * leetcode - https://leetcode.com/problems/find-the-difference/
 *
 * Data Structure - [IntArray]
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(26)
 *
 * Companies - Google
 */
private fun findTheDifferenceUsingCounter(s: String, t: String): Char {
    val counter = IntArray(26)
    for (char in t) {
        counter[char - 'a']++
    }
    for (char in s) {
        counter[char - 'a']--
    }
    for (i in 0..25) {
        if (counter[i] > 0) {
            return 'a' + i
        }
    }
    return 'a'
}
