package leetcode.leetcode_1482_minimum_number_of_days_to_make_m_bouquets

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Stats
 * Runtime: 449 ms, faster than 75.00%
 * Memory Usage: 53 MB, less than 75.00%
 */
private fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
    if (m * k > bloomDay.size) {
        return -1
    }

    fun isFeasible(n: Int): Boolean {
        var current = 0
        var result = 0
        bloomDay.forEach {
            if (it <= n) {
                current++
                if (current == k) {
                    current = 0
                    result++
                    if (result == m) {
                        return true
                    }
                }
            } else {
                current = 0
            }
        }
        return false
    }

    var left = 1
    var right = bloomDay.max()
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (isFeasible(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
