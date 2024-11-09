package leetcode.leetcode_3211_generate_binary_strings_without_adjacent_zeros

/**
 * leetcode - https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 220 ms, faster than 50.00%
 * Memory Usage: 39.3 MB, less than 56.00%
 *
 * Time -
 * Space -
 */
private fun validStrings(n: Int): List<String> {
    val result = mutableListOf<String>()
    fun generate(current: String) {
        if (current.length == n) {
            result.add(current)
            return
        }
        generate(current + "1")
        if (current.isEmpty() || current.last() != '0') {
            generate(current + "0")
        }
    }
    generate("")
    return result
}

private fun main() {

}
