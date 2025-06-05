package leetcode.leetcode_1723_find_minimum_time_to_finish_all_jobs

/**
 * leetcode - https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun minimumTimeRequired(jobs: IntArray, k: Int): Int {
    val sum = jobs.sum()

    fun canComplete(maxTime: Int): Boolean {
        val isUsed = BooleanArray(jobs.size)
        fun backtrack(index: Int, remaining: Int, currentSum: Int): Boolean {
            if (remaining == 0) {
                return true
            }
            if (index == jobs.size) {
                return false
            }
            if (!isUsed[index] && jobs[index] + currentSum <= maxTime) {
                isUsed[index] = true
                if (backtrack(index + 1, remaining, currentSum)) {
                    return true
                }
                isUsed[index] = false
            }
            return backtrack(index + 1, remaining, currentSum)
        }
        return backtrack(0, k, 0)
    }

    var left = sum / k
    var right = sum
    while (left < right) {
        val mid = left + (right - left) / 2
        if (canComplete(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
