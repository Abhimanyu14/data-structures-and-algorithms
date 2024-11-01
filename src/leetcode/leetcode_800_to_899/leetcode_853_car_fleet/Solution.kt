package leetcode.leetcode_800_to_899.leetcode_853_car_fleet

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/car-fleet/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 678 ms, faster than 76.51%
 * Memory Usage: 56.7 MB, less than 30.30%
 */
private fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    // Sort in descending order by position
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        p2.first - p1.first
    }
    for (i in position.indices) {
        priorityQueue.offer(Pair(position[i], speed[i]))
    }
    var temp = priorityQueue.poll()
    var lastTimeTaken = (target.toDouble() - temp.first) / temp.second
    var currentTimeTaken: Double
    var result = 1
    while (priorityQueue.isNotEmpty()) {
        temp = priorityQueue.poll()
        currentTimeTaken = (target.toDouble() - temp.first) / temp.second
        if (currentTimeTaken > lastTimeTaken) {
            lastTimeTaken = currentTimeTaken
            result++
        }
    }
    return result
}

private fun main() {

}
