package leetcode.leetcode_1652_defuse_the_bomb

/**
 * leetcode - https://leetcode.com/problems/defuse-the-bomb/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 171 ms, faster than 66.67%
 * Memory Usage: 38 MB, less than 33.33%
 */
private fun decrypt(code: IntArray, k: Int): IntArray {
    val result = IntArray(code.size)
    if (k > 0) {
        for (i in 1..k) {
            result[0] += code[i]
        }
        for (i in 1..code.lastIndex) {
            result[i] = result[i - 1] - code[i] + code[(i + k) % code.size]
        }
    } else if (k < 0) {
        for (i in (code.size + k)..code.lastIndex) {
            result[0] += code[i]
        }
        for (i in 1..code.lastIndex) {
            result[i] = result[i - 1] + code[i - 1] - code[(code.lastIndex + k + i) % code.size]
        }
    }
    return result
}
private fun main() {

}
