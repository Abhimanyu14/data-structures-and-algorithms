package leetcode.leetcode_200_to_299.leetcode_210_course_schedule_ii

/**
 * leetcode - https://leetcode.com/problems/course-schedule-ii/
 *
 * Using Topological sort - Kahn's
 *
 * Stats
 * Runtime: 271 ms, faster than 22.99%
 * Memory Usage: 41.8 MB, less than 66.67%
 */
private fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val inDegrees = MutableList(numCourses) { 0 }
    val graph = mutableMapOf<Int, MutableList<Int>>()
    prerequisites.forEach {
        graph.computeIfAbsent(it[0]) {
            mutableListOf()
        }.add(it[1])
        inDegrees[it[1]]++
    }
    val queue = ArrayDeque<Int>()
    inDegrees.forEachIndexed { index, value ->
        if (value == 0) {
            queue.addLast(index)
        }
    }
    val result = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val temp = queue.removeFirst()
        graph[temp]?.forEach {
            inDegrees[it]--
            if (inDegrees[it] == 0) {
                queue.addLast(it)
            }
        }
        result.add(temp)
    }
    return if (result.size == numCourses) {
        result.toIntArray().reversedArray()
    } else {
        intArrayOf()
    }
}

private fun main() {

}
