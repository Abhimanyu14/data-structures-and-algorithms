package leetcode.leetcode_670_maximum_swap

/**
 * leetcode - https://leetcode.com/problems/maximum-swap/
 *
 * TODO(Abhi) - To revisit
 *
 * Using greedy
 *
 * Stats
 * Runtime: 149 ms, faster than 41.49%
 * Memory Usage: 33.3 MB, less than 79.79%
 */
private fun maximumSwap(num: Int): Int {
    val chars = num.toString().toCharArray()
    val last = IntArray(10)
    for (i in chars.indices) {
        last[chars[i] - '0'] = i
    }
    for (i in chars.indices) {
        for (digit in 9 downTo chars[i] - '0' + 1) {
            if (last[digit] > i) {
                chars[i] = chars[last[digit]].also {
                    chars[last[digit]] = chars[i]
                }
                return String(chars).toInt()
            }
        }
    }
    return num
}

private fun main() {

}
