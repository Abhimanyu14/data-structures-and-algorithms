package leetcode.leetcode_2224_minimum_number_of_operations_to_convert_time

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 * Runtime: 1 ms, faster than 50.00%
 * Memory Usage: 34.9 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun convertTime(current: String, correct: String): Int {
    var result = 0
    fun getMinutes(x: String): Int {
        return ((((x[0] - '0') * 10) + (x[1] - '0')) * 60) + (((x[3] - '0') * 10) + (x[4] - '0'))
    }
    var currentMinutes = getMinutes(current)
    var correctMinutes = getMinutes(correct)
    if (correctMinutes < currentMinutes) {
        correctMinutes += (60 * 24)
    }
    while (currentMinutes < correctMinutes) {
        if (currentMinutes + 60 <= correctMinutes) {
            val bump = ((correctMinutes - currentMinutes) / 60)
            currentMinutes += (bump * 60)
            result += bump
        }
        if (currentMinutes + 15 <= correctMinutes) {
            val bump = ((correctMinutes - currentMinutes) / 15)
            currentMinutes += (bump * 15)
            result += bump
        }
        if (currentMinutes + 5 <= correctMinutes) {
            val bump = ((correctMinutes - currentMinutes) / 5)
            currentMinutes += (bump * 5)
            result += bump
        }
        if (currentMinutes + 1 <= correctMinutes) {
            val bump = ((correctMinutes - currentMinutes) / 1)
            currentMinutes += (bump * 1)
            result += bump
        }
    }
    return result
}

private fun main() {

}
