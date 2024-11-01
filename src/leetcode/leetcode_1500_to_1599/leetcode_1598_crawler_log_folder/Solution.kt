package leetcode.leetcode_1500_to_1599.leetcode_1598_crawler_log_folder

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/crawler-log-folder/?envType=daily-question&envId=2024-07-10
 *
 * Using single iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 185 ms, faster than 15.38%
 * Memory Usage: 35.8 MB, less than 23.08%
 *
 * Time -
 * Space -
 */
private fun minOperations(logs: Array<String>): Int {
    var result = 0
    logs.forEach {
        if (it == "../") {
            result = max(0, result - 1)
        } else if (it != "./") {
            result++
        }
    }
    return result
}

private fun main() {

}
