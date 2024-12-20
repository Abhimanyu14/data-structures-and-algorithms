package leetcode.leetcode_3210_find_the_encrypted_string

/**
 * leetcode - https://leetcode.com/problems/find-the-encrypted-string/
 *
 * Data Structure - StringBuilder
 * Algorithm - Iteration and String Building
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 36.2 MB, less than 71.43%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun getEncryptedString(s: String, k: Int): String {
    val result = StringBuilder()
    var index = k % s.length
    repeat(s.length) {
        result.append(s[index])
        index = (index + 1) % s.length
    }
    return result.toString()
}

private fun main() {

}
