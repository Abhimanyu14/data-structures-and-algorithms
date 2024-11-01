package leetcode.leetcode_0_to_99.leetcode_91_decode_ways

/**
 * leetcode - https://leetcode.com/problems/decode-ways/
 *
 * Using map and recursion
 *
 * Stats
 * Runtime: 156 ms, faster than 51.16%
 * Memory Usage: 35.6 MB, less than 38.76%
 */
private fun numDecodings(s: String): Int {
    // leading zeroes
    if (s[0] == '0') {
        return 0
    }
    // string of length 1
    if (s.length == 1) {
        return 1
    }
    val memo = mutableMapOf<Int, Int>()
    fun getCount(index: Int): Int {
        memo[index]?.let {
            return it
        }
        memo[index] = if (s[index] == '0') {
            // invalid mapping
            0
        } else if (index == s.lastIndex) {
            // string of length 1
            1
        } else {
            if ((s[index] == '1') || (s[index] == '2' && s[index + 1] - '0' <= 6)) {
                if (s.lastIndex == index + 1) {
                    getCount(index + 1) + 1
                } else {
                    getCount(index + 1) + getCount(index + 2)
                }
            } else {
                getCount(index + 1)
            }
        }
        return memo[index] ?: 0
    }
    return getCount(0)
}

private fun main() {

}
