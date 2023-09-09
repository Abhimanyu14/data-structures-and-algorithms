package leetcode.leet_500_to_599.leet_502_ipo

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/ipo/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 697 ms, faster than 46.15%
 * Memory Usage: 63.5 MB, less than 15.38%
 */
private data class Project(
    val profit: Int,
    val capital: Int,
)

private class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
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
        var projectIndex = -1
        for (i in 0 until k) {
            while (projectIndex < projects.lastIndex && projects[projectIndex + 1].capital <= result) {
                projectIndex++
                possibleProjects.offer(projects[projectIndex])
            }
            if (possibleProjects.isEmpty()) {
                break
            } else {
                result += possibleProjects.poll().profit
            }
        }
        return result
    }
}

private fun main() {

}
