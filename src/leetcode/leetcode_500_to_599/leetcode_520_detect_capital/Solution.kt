package leetcode.leetcode_500_to_599.leetcode_520_detect_capital

/**
 * leetcode - https://leetcode.com/problems/detect-capital/
 *
 * Using string methods - isUpperCase(), count()
 *
 * Stats
 * Runtime: 146 ms, faster than 100.00%
 * Memory Usage: 34.1 MB, less than 81.25%
 */
private fun detectCapitalUse(word: String): Boolean {
    return when (word.count { it.isUpperCase() }) {
        0, word.length -> {
            true
        }
        1 -> {
            word[0].isUpperCase()
        }
        else -> {
            false
        }
    }
}

private fun main() {

}
