package leetcode.leetcode_1928_minimum_cost_to_reach_destination_in_time

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private data class Move(
    val node: Int,
    val cost: Int,
    val time: Int,
)

private fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
    val graph = Array(passingFees.size) {
        mutableListOf<Pair<Int, Int>>()
    }
    for (edge in edges) {
        graph[edge[0]].add(Pair(edge[1], edge[2]))
        graph[edge[1]].add(Pair(edge[0], edge[2]))
    }
    val minCost = IntArray(passingFees.size) {
        Int.MAX_VALUE
    }
    val priorityQueue = PriorityQueue<Move> { a, b ->
        a.cost - b.cost
    }
    priorityQueue.offer(Move(0, passingFees[0], 0))
    while (priorityQueue.isNotEmpty()) {
        val (node, cost, time) = priorityQueue.poll()
        if (minCost[node] <= cost) {
            continue
        }
        minCost[node] = cost
        graph[node].forEach { (neighbour, time1) ->
            if (time + time1 < maxTime) {
                if (neighbour == passingFees.lastIndex) {
                    minCost[passingFees.lastIndex] = cost + passingFees.last()
                } else {
                    priorityQueue.offer(Move(neighbour, cost + passingFees[neighbour], time + time1))
                }
            }
        }
    }
    return minCost.last()
}

private fun main() {

}
