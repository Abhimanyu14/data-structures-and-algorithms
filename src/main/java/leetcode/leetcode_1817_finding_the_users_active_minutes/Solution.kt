package leetcode.leetcode_1817_finding_the_users_active_minutes

/**
 * leetcode - https://leetcode.com/problems/finding-the-users-active-minutes/
 *
 * Data Structure - Map, Set and Array
 * Algorithm - Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 66 ms, faster than 33.33%
 * Memory Usage: 57.5 MB, less than 33.33%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
    val result = IntArray(k)
    val activity = mutableMapOf<Int, MutableSet<Int>>()
    for (log in logs) {
        activity.computeIfAbsent(log[0]) { mutableSetOf() }.add(log[1])
    }
    for ((_, value) in activity) {
        result[value.size - 1]++
    }
    return result
}

private fun main() {

}
