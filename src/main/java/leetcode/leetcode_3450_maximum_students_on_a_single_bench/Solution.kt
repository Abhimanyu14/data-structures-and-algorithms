package leetcode.leetcode_3450_maximum_students_on_a_single_bench

import kotlin.math.max

/**
 * leetcode -
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
private fun maxStudentsOnBench(students: Array<IntArray>): Int {
    var result = 0
    val map = mutableMapOf<Int, MutableSet<Int>>()
    for ((studentId, benchId) in students) {
        map.computeIfAbsent(benchId) {
            mutableSetOf()
        }.add(studentId)
        result = max(result, map[benchId]?.size ?: 0)
    }
    return result
}

private fun main() {

}
