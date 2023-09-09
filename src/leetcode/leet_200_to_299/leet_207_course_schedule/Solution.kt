package leetcode.leet_200_to_299.leet_207_course_schedule

/**
 * leetcode - https://leetcode.com/problems/course-schedule/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Stats
 *
 */
private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val visited = mutableSetOf<Int>()
    fun hasLoops(start: Int) : Boolean {
        println("start: $start")
        if (visited.contains(start)) {
            return true
        }
        visited.add(start)
        for (node in graph.getOrDefault(start, mutableListOf())) {
            if (hasLoops(node)) {
                return true
            }
        }
        return false
    }

    for (i in prerequisites.indices) {
        graph.computeIfAbsent(prerequisites[i][1]) { mutableListOf() }.add(prerequisites[i][0])
        visited.clear()
        if (hasLoops(prerequisites[i][1])) {
            return false
        }
    }
    return true
}

private fun main() {

}
