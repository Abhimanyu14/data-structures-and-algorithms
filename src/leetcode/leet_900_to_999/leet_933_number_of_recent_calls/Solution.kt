package leetcode.leet_900_to_999.leet_933_number_of_recent_calls

/**
 * leetcode - https://leetcode.com/problems/number-of-recent-calls/
 *
 * Using Queue
 *
 * Stats
 * Runtime: 476 ms, faster than 45.94%
 * Memory Usage: 70 MB, less than 5.40%
 */
private class RecentCounter() {
    val queue = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        queue.addLast(t)
        while (queue.first() < t - 3000) {
            queue.removeFirst()
        }
        return queue.size
    }

}
private fun main() {

}
