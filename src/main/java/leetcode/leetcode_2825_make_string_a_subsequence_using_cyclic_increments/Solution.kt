package leetcode.leetcode_2825_make_string_a_subsequence_using_cyclic_increments

/**
 * leetcode - https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/?envType=daily-question&envId=2024-12-04
 *
 * Data Structure - NA
 * Algorithm - Two Pointers
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 13 ms, faster than 25.00%
 * Memory Usage: 40.7 MB, less than 25.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun canMakeSubsequence(str1: String, str2: String): Boolean {
    fun getNextCyclicChar(char: Char): Char {
        if (char == 'z') {
            return 'a'
        }
        return char + 1
    }
    var index1 = 0
    var index2 = 0
    while (index1 < str1.length && index2 < str2.length) {
        if (str1[index1] == str2[index2] || getNextCyclicChar(str1[index1]) == str2[index2]) {
            index2++
        }
        index1++
    }
    return index2 == str2.length
}

/**
 * leetcode - https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/?envType=daily-question&envId=2024-12-04
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Memory Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun canMakeSubsequenceUsingRecursion(str1: String, str2: String): Boolean {
    if (str2.length > str1.length) {
        return false
    }
    fun nextChar(char: Char): Char {
        if (char == 'z') {
            return 'a'
        }
        return char + 1
    }

    fun canMatch(s1: String, index1: Int, index2: Int): Boolean {
        if (s1 == str2) {
            return true
        }
        if (index1 == str1.length || index2 == str2.length) {
            return false
        }
        if ((str1[index1] == str2[index2]) && (canMatch(s1 + str1[index1], index1 + 1, index2 + 1))) {
            return true
        }
        if ((nextChar(str1[index1]) == str2[index2]) &&
            (canMatch(s1 + nextChar(str1[index1]), index1 + 1, index2 + 1))
        ) {
            return true
        }
        return canMatch(s1, index1 + 1, index2)
    }
    return canMatch("", 0, 0)
}

private fun main() {

}
