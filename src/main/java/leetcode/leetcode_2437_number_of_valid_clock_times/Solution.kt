package leetcode.leetcode_2437_number_of_valid_clock_times

/**
 * Using conditional operators
 *
 * leetcode - https://leetcode.com/problems/number-of-valid-clock-times/
 *
 * Stats
 * Runtime: 144 ms, faster than 100.00%
 * Memory Usage: 33.1 MB, less than 100.00%
 *
 * Note: leetcode does not support digitToInt(), so use "char - '0'" instead
 */
private fun countTime(time: String): Int {
    var result = if (time[0] != '?' && time[1] != '?') {
        1
    } else if (time[0] == '?' && time[1] == '?') {
        24
    } else {
        if (time[0] == '?') {
            if (time[1] - '0' > 3) {
                2
            } else {
                3
            }
        } else {
            if (time[0] - '0' < 2) {
                10
            } else {
                4
            }
        }
    }
    if (time[3] == '?') {
        result *= 6
    }
    if (time[4] == '?') {
        result *= 10
    }
    return result
}

private fun main() {

}
