package leetcode.leetcode_2050_parallel_courses_iii

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/parallel-courses-iii/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Topological Sort, Kahn's Algorithm
 *
 * Stats
 * Runtime: 716 ms, faster than 100.00%
 * Memory Usage: 82.7 MB, less than 100.00%
 */
private fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
    val graph: MutableMap<Int, MutableList<Int>> = HashMap()
    for (i in 0..<n) {
        graph[i] = ArrayList()
    }
    val indegree = IntArray(n)
    for (edge in relations) {
        val x = edge[0] - 1
        val y = edge[1] - 1
        graph[x]!!.add(y)
        indegree[y]++
    }
    val queue: Queue<Int> = LinkedList()
    val maxTime = IntArray(n)
    for (node in 0..<n) {
        if (indegree[node] == 0) {
            queue.add(node)
            maxTime[node] = time[node]
        }
    }
    while (!queue.isEmpty()) {
        val node = queue.remove()
        for (neighbor in graph[node]!!) {
            maxTime[neighbor] =
                max(maxTime[neighbor].toDouble(), (maxTime[node] + time[neighbor]).toDouble()).toInt()
            indegree[neighbor]--
            if (indegree[neighbor] == 0) {
                queue.add(neighbor)
            }
        }
    }
    var ans = 0
    for (node in 0..<n) {
        ans = max(ans.toDouble(), maxTime[node].toDouble()).toInt()
    }
    return ans
}
private fun main() {

}
