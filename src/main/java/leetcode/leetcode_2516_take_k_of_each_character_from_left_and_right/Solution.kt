package leetcode.leetcode_2516_take_k_of_each_character_from_left_and_right

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
 *
 * Using sliding window
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun takeCharacters(s: String, k: Int): Int {
    val counter = IntArray(3)
    s.forEach {
        counter[it - 'a']++
    }
    repeat(3) {
        if (counter[it] < k) {
            return -1
        }
    }
    val windowCounter = IntArray(3)
    var left = 0
    var maxWindow = 0
    for (right in s.indices) {
        windowCounter[s[right] - 'a']++
        while (left <= right && (counter[0] - windowCounter[0] < k || counter[1] - windowCounter[1] < k || counter[2] - windowCounter[2] < k)) {
            windowCounter[s[left] - 'a']--
            left++
        }
        maxWindow = max(maxWindow, (right - left + 1))
    }
    return s.length - maxWindow
}

private fun main() {

}
