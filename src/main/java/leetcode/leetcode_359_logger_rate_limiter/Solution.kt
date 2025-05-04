package leetcode.leetcode_359_logger_rate_limiter

/**
 * leetcode - https://leetcode.com/problems/logger-rate-limiter/?envType=company&envId=google&favoriteSlug=google-thirty-days
 * Premium Question
 *
 * Data Structure - [Map]
 * Algorithm - Hashing
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 345 ms, faster than 100.00%
 * Memory Usage: 53.8 MB, less than 86.73%
 *
 * Time - O(1)
 * Space - O(N)
 *
 * Companies - Google
 */
private class Logger {
    val cache = mutableMapOf<String, Int>()
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (!cache.contains(message) || timestamp - (cache[message] ?: 0) >= 10) {
            cache[message] = timestamp
            return true
        }
        return false
    }
}

private fun main() {

}
