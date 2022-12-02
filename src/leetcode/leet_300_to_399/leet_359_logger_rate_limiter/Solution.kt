package leetcode.leet_300_to_399.leet_359_logger_rate_limiter

/**
 * Using hashmap
 *
 * Stats
 * Runtime: 345 ms, faster than 100.00%
 * Memory Usage: 53.8 MB, less than 86.73%
 */
class Logger() {
    val map = HashMap<String,Int>()
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (!map.contains(message) || timestamp - (map[message] ?: 0) >= 10) {
            map[message] = timestamp
            return true
        }
        return false
    }
}

private fun main() {

}
