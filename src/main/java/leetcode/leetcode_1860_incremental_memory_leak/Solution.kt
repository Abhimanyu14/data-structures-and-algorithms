package leetcode.leetcode_1860_incremental_memory_leak

/**
 * leetcode - https://leetcode.com/problems/incremental-memory-leak/
 *
 * Data Structure - NA
 * Algorithm - Simulation
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 3 ms, faster than 100.00%
 * Memory Usage: 34.7 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun memLeak(memory1: Int, memory2: Int): IntArray {
    val result = IntArray(3)
    var m1 = memory1
    var m2 = memory2
    var time = 0
    while (true) {
        time++
        if (m1 >= m2) {
            if (time > m1) {
                break
            } else {
                m1 -= time
            }
        } else {
            if (time > m2) {
                break
            } else {
                m2 -= time
            }
        }
    }
    result[0] = time
    result[1] = m1
    result[2] = m2
    return result
}

private fun main() {

}
