package leetcode.leetcode_743_network_delay_time

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/network-delay-time/
 *
 * TODO-Abhi: To revisit
 *
 * Using Dijkstra algorithm
 *
 * Stats
 * Runtime: 332 ms, faster than 60.42%
 * Memory Usage: 55 MB, less than 32.29%
 */
private fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    times.forEach { (from, to, weight) ->
        graph.computeIfAbsent(from) {
            mutableListOf()
        }.add(Pair(to, weight))
    }

    val signalReceivedTime = IntArray(n + 1) { Int.MAX_VALUE }
    signalReceivedTime[k] = 0

    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.second - b.second
    }
    priorityQueue.add(Pair(k, 0))

    while (priorityQueue.isNotEmpty()) {
        val (currNode, currNodeTime) = priorityQueue.poll()
        if (currNodeTime > signalReceivedTime[currNode]) {
            continue
        }
        // To handle 1 indexed
        if (!graph.containsKey(currNode)) {
            continue
        }
        graph[currNode]?.forEach { (neighborNode, time) ->
            if (signalReceivedTime[neighborNode] > currNodeTime + time) {
                signalReceivedTime[neighborNode] = currNodeTime + time
                priorityQueue.add(Pair(neighborNode, signalReceivedTime[neighborNode]))
            }
        }
    }

    var answer = Int.MIN_VALUE
    for (i in 1..n) {
        answer = max(answer, signalReceivedTime[i])
    }
    return if (answer == Int.MAX_VALUE) {
        -1
    } else {
        answer
    }
}

private fun main() {

}
