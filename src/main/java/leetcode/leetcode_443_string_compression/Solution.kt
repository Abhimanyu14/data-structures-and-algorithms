package leetcode.leetcode_443_string_compression

/**
 * leetcode - https://leetcode.com/problems/string-compression/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Iteration & Counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun compress(chars: CharArray): Int {
    var left = 0
    var right = 1
    var count = 1
    fun updateCount() {
        if (count > 1) {
            for (digit in count.toString()) {
                left++
                chars[left] = digit
            }
        }
    }

    while (right <= chars.lastIndex) {
        if (chars[right] == chars[left]) {
            count++
        } else {
            updateCount()
            left++
            chars[left] = chars[right]
            count = 1
        }
        right++
    }
    updateCount()
    return left + 1
}

private fun main() {

}
