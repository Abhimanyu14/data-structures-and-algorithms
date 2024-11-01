package leetcode.leetcode_900_to_999.leetcode_949_largest_time_for_given_digits

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/largest-time-for-given-digits/
 *
 * TODO(Abhi) - To revisit
 *
 * Using permutation
 *
 * Stats
 * Runtime: 192 ms, faster than 50.00%
 * Memory Usage: 37.9 MB, less than 50.00%
 */
private fun largestTimeFromDigits(arr: IntArray): String {
    var maxMinutes = -1

    fun buildTime() {
        val hour = arr[0] * 10 + arr[1]
        val minute = arr[2] * 10 + arr[3]
        if (hour < 24 && minute < 60) {
            maxMinutes = max(maxMinutes, (hour * 60 + minute))
        }
    }

    fun swap(i: Int, j: Int) {
        if (i != j) {
            arr[i] = arr[j].also {
                arr[j] = arr[i]
            }
        }
    }

    fun permute(start: Int) {
        if (start == arr.size) {
            buildTime()
            return
        }
        for (i in start..arr.lastIndex) {
            swap(i, start)
            permute(start + 1)
            swap(i, start)
        }
    }

    permute(0)
    return if (maxMinutes == -1) {
        ""
    } else {
        String.format("%02d:%02d", maxMinutes / 60, maxMinutes % 60)
    }
}

private fun main() {

}
