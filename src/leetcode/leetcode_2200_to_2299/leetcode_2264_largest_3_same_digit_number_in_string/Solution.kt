package leetcode.leetcode_2200_to_2299.leetcode_2264_largest_3_same_digit_number_in_string

/**
 * leetcode - https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 *
 * Using char, string, loops
 *
 * Stats
 * Runtime: 155 ms, faster than 80.00%
 * Memory Usage: 34.7 MB, less than 80.00%
 */
private fun largestGoodInteger(num: String): String {
    if (num.length < 3) {
        return ""
    }
    var result: Int = -1
    for (i in 0..(num.length - 3)) {
        if (num[i] == num[i + 1] && num[i + 1] == num[i + 2]) {
            if (num[i].toString().toInt() > result) {
                result = num[i].toString().toInt()
            }
        }
    }
    if (result == -1) {
        return ""
    }
    return "$result$result$result"
}

private fun main() {

}
