package leetcode.leetcode_3751_total_waviness_of_numbers_in_range_i

/**
 * leetcode - https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - String
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun totalWaviness(num1: Int, num2: Int): Int {
    fun getWaviness(x: Int): Int {
        if (x < 100) {
            return 0
        }
        var count = 0
        val string = x.toString()
        for (i in 1..(string.lastIndex - 1)) {
            if (string[i] > string[i - 1] && string[i] > string[i + 1]) {
                count++
            }
            if (string[i] < string[i - 1] && string[i] < string[i + 1]) {
                count++
            }
        }
        return count
    }

    var result = 0
    for (i in num1..num2) {
        result += getWaviness(i)
    }
    return result
}
