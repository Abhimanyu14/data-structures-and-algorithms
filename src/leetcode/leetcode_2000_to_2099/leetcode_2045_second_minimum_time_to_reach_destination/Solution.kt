package leetcode.leetcode_2000_to_2099.leetcode_2045_second_minimum_time_to_reach_destination

import java.util.LinkedList
import java.util.Queue


/**
 * leetcode - https://leetcode.com/problems/second-minimum-time-to-reach-destination/?envType=daily-question&envId=2024-07-28
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    for (edge in edges) {
        val a = edge[0]
        val b = edge[1]
        adj.computeIfAbsent(
            a
        ) { value: Int? -> ArrayList() }.add(b)
        adj.computeIfAbsent(
            b
        ) { value: Int? -> ArrayList() }.add(a)
    }
    val dist1 = IntArray(n + 1)
    val dist2 = IntArray(n + 1)
    for (i in 1..n) {
        dist2[i] = -1
        dist1[i] = dist2[i]
    }
    val queue: Queue<IntArray> = LinkedList()
    // Start with node 1, with its minimum distance.
    queue.offer(intArrayOf(1, 1))
    dist1[1] = 0

    while (!queue.isEmpty()) {
        val temp = queue.poll()
        val node = temp[0]
        val freq = temp[1]

        var timeTaken = if (freq == 1) dist1[node] else dist2[node]
        // If the time_taken falls under the red bracket, wait till the path turns
        // green.
        timeTaken = if ((timeTaken / change) % 2 == 1) {
            change * (timeTaken / change + 1) + time
        } else {
            timeTaken + time
        }

        if (!adj.containsKey(node)) continue
        for (neighbor in adj[node]!!) {
            if (dist1[neighbor] == -1) {
                dist1[neighbor] = timeTaken
                queue.offer(intArrayOf(neighbor, 1))
            } else if (dist2[neighbor] == -1 && dist1[neighbor] != timeTaken) {
                if (neighbor == n) return timeTaken
                dist2[neighbor] = timeTaken
                queue.offer(intArrayOf(neighbor, 2))
            }
        }
    }
    return 0
}

private fun main() {

}
