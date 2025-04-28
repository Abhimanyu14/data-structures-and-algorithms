package leetcode.leetcode_207_course_schedule

private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph: List<MutableList<Int>> = MutableList(numCourses) {
        mutableListOf()
    }
    for ((before, after) in prerequisites) {
        graph[after].add(before)
    }
    val visited = BooleanArray(numCourses)
    val inStack = BooleanArray(numCourses)

    fun dfs(node: Int): Boolean {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true
        }
        if (visited[node]) {
            return false
        }
        // Mark the current node as visited and part of current recursion stack.
        visited[node] = true
        inStack[node] = true
        for (neighbor in graph[node]) {
            if (dfs(neighbor)) {
                return true
            }
        }
        // Remove the node from the stack.
        inStack[node] = false
        return false
    }

    for (i in 0..<numCourses) {
        if (dfs(i)) {
            return false
        }
    }
    return true
}

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
private fun canFinishUsingTopologicalSort(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
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
