package leetcode.leetcode_207_course_schedule

/**
 * leetcode - https://leetcode.com/problems/course-schedule/
 *  * https://leetcode.com/problems/course-schedule/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Topological sort - Kahn's
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 255 ms, faster than 14.09%
 * Memory Usage: 44.5 MB, less than 16.49%
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
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
    return result.size == numCourses
}

private fun main() {

}
