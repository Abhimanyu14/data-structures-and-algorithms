package leetcode.leetcode_1700_to_1799.leetcode_1710_maximum_units_on_a_truck

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/maximum-units-on-a-truck/
 *
 * Using sortedByDescending
 *
 * Stats
 * Runtime: 485 ms, faster than 65.52%
 * Memory Usage: 66 MB, less than 37.93%
 */
private fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    val sorted = boxTypes.sortedByDescending { it[1] }
    var remaining = truckSize
    var result = 0
    for (s in sorted) {
        if (remaining < s[0]) {
            result += remaining * s[1]
            break
        } else {
            result += s[0] * s[1]
            remaining -= s[0]
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-units-on-a-truck/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 229 ms, faster than 100.00%
 * Memory Usage: 42.6 MB, less than 96.55%
 */
private fun maximumUnitsUsingPriorityQueue(boxTypes: Array<IntArray>, truckSize: Int): Int {
    val priorityQueue = PriorityQueue<IntArray> { o1, o2 ->
        o2[1] - o1[1]
    }
    boxTypes.forEach {
        priorityQueue.offer(it)
    }
    var remaining = truckSize
    var result = 0
    while (remaining > 0 && priorityQueue.isNotEmpty()) {
        val next = priorityQueue.poll()
        if (remaining < next[0]) {
            result += remaining * next[1]
            break
        } else {
            result += next[0] * next[1]
            remaining -= next[0]
        }
    }
    return result
}

private fun main() {

}
