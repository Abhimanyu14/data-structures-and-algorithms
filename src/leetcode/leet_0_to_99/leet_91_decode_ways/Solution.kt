package leetcode.leet_0_to_99.leet_91_decode_ways

/**
 * leetcode - https://leetcode.com/problems/decode-ways/
 *
 * Using
 *
 * Stats
 *
 */
private fun numDecodings(s: String): Int {
    val memo = mutableMapOf<Int, Int>()

    fun numDecodings(s: String, index: Int): Int {
        if (memo.contains(index)) {
            return memo[index] ?: 0
        }
        if (s.isEmpty()) {
            return 1
        }
        if (s.first() == '0') {
            return 0
        }
        if (index == s.lastIndex) {
            return 1
        }
        var result = numDecodings(s, index + 1)
        if (s.substring(index, index + 2).toInt() <= 26) {
            result += numDecodings(s, index + 2)
        }
        memo[index] = result
        return result
    }
    return numDecodings(s, 0)
}

private fun main() {

}
