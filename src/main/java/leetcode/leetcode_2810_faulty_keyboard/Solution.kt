package leetcode.leetcode_2810_faulty_keyboard

/**
 * leetcode - https://leetcode.com/problems/faulty-keyboard/description/
 *
 * Using StringBuilder [reverse]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 4 ms, faster than 100.00%
 * Memory Usage: 37.3 MB, less than 64.71%
 *
 * Time -
 * Space -
 */
private fun finalString(s: String): String {
    val result = StringBuilder()
    s.forEach {
        if (it == 'i') {
            result.reverse()
        } else {
            result.append(it)
        }
    }
    return result.toString()
}

private fun main() {

}
