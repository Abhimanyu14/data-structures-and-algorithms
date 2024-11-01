package leetcode.leetcode_1700_to_1799.leetcode_1759_count_number_of_homogenous_substrings

/**
 * leetcode - https://leetcode.com/problems/count-number-of-homogenous-substrings/
 *
 * Using maths - Sum of n numbers
 *
 * Stats
 * Runtime: 231 ms, faster than 100.00%
 * Memory Usage: 38.6 MB, less than 100.00%
 */
private fun countHomogenous(s: String): Int {
    var counter = 0L
    val mod = 1000_000_007
    var prev = s[0]
    var prevCount = 1L
    for (i in 1..s.lastIndex) {
        if (s[i] == prev) {
            prevCount++
        } else {
            counter = (counter + ((prevCount * (prevCount + 1)) / 2)) % mod
            prevCount = 1
            prev = s[i]
        }
    }
    counter = (counter + (((prevCount * (prevCount + 1)) / 2) % mod)) % mod
    return counter.toInt()
}

private fun main() {
    val n = 100_000L
    println("${(n * (n + 1) / 2)}")
    println("${(n * (n + 1) / 2) % 1000_000_009}")
}
