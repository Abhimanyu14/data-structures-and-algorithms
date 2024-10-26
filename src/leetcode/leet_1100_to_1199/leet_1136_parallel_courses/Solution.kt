package leetcode.leet_1100_to_1199.leet_1136_parallel_courses

/**
 * leetcode - https://leetcode.com/problems/parallel-courses/
 *
 * TODO(Abhi) - To revisit
 *
 * Using graph and sets
 *
 * Stats
 * Runtime: 529 ms, faster than 13.79%
 * Memory Usage: 56 MB, less than 10.34%
 */
private fun minimumSemesters(n: Int, relations: Array<IntArray>): Int {
    var semestersCompleted = 0
    val coursePrerequisiteGraph = mutableMapOf<Int, MutableSet<Int>>()
    val completedCourses = mutableSetOf<Int>()
    val willComplete = mutableSetOf<Int>()
    repeat(n) {
        coursePrerequisiteGraph[it + 1] = mutableSetOf()
    }
    relations.forEach {
        coursePrerequisiteGraph[it[1]]?.add(it[0])
    }

    var shouldContinue = true
    while (shouldContinue) {
        shouldContinue = false
        willComplete.clear()
        coursePrerequisiteGraph.forEach { (key, value) ->
            value.removeAll(completedCourses)
            if (value.isEmpty() && !completedCourses.contains(key)) {
                shouldContinue = true
                willComplete.add(key)
            }
        }
        completedCourses.addAll(willComplete)
        if (shouldContinue) {
            semestersCompleted++
        }
    }

    if (completedCourses.size != n) {
        return -1
    }
    return semestersCompleted
}

private fun main() {
    println(minimumSemesters(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))))
    // println(minimumSemesters(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))))
}
