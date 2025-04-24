package leetcode.leetcode_249_group_shifted_strings

/**
 * leetcode - https://leetcode.com/problems/group-shifted-strings/description/
 * Premium Question
 *
 * Data Structure - [Map], [StringBuilder]
 * Algorithm - Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * m)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun groupStrings(strings: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    fun getKey(string: String): String {
        val key = StringBuilder()
        val diff = string[0] - 'a'
        for (char in string) {
            key.append('a' + ((char - 'a' - diff + 26) % 26))
        }
        return key.toString()
    }
    for (string in strings) {
        val key = getKey(string)
        map.computeIfAbsent(key) {
            mutableListOf()
        }.add(string)
    }
    return map.values.toList()
}

private fun main() {

}
