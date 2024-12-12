package leetcode.leetcode_502_ipo

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/ipo/
 *
 * Data Structure - PriorityQueue
 * Algorithm - Sorting and Heap
 *
 * Using Two PriorityQueues
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 181 ms, faster than 56.76%
 * Memory Usage: 63.1 MB, less than 34.09%
 *
 * Time - O(M * log(N))
 * Space - O(N)
 */
private data class Project(
    val profit: Int,
    val capital: Int,
)

private fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    val projects = PriorityQueue<Project> { a, b ->
        a.capital - b.capital
    }
    for (i in 0..profits.lastIndex) {
        projects.offer(Project(profits[i], capital[i]))
    }
    val possibleProjects = PriorityQueue<Project> { a, b ->
        b.profit - a.profit
    }
    var result = w
    for (i in 0..<k) {
        while (projects.isNotEmpty() && projects.first().capital <= result) {
            possibleProjects.offer(projects.poll())
        }
        if (possibleProjects.isEmpty()) {
            return result
        } else {
            result += possibleProjects.poll().profit
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/ipo/
 *
 * Data Structure - Array and PriorityQueue
 * Algorithm - Sorting and Heap
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 191 ms, faster than 51.35%
 * Memory Usage: 64.1 MB, less than 25.00%
 *
 * Time -
 * Space -
 */
private fun findMaximizedCapitalUsingSorting(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    val projects = mutableListOf<Project>()
    for (i in 0..profits.lastIndex) {
        projects.add(Project(profits[i], capital[i]))
    }
    projects.sortBy {
        it.capital
    }
    val possibleProjects = PriorityQueue<Project> { a, b ->
        b.profit - a.profit
    }
    var result = w
    var projectIndex = 0
    for (i in 0..<k) {
        while (projectIndex <= projects.lastIndex && projects[projectIndex].capital <= result) {
            possibleProjects.offer(projects[projectIndex])
            projectIndex++
        }
        if (possibleProjects.isEmpty()) {
            break
        } else {
            result += possibleProjects.poll().profit
        }
    }
    return result
}

private fun main() {

}
