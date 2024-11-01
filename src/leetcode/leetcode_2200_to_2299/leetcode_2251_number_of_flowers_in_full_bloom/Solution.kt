package leetcode.leetcode_2200_to_2299.leetcode_2251_number_of_flowers_in_full_bloom

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/number-of-flowers-in-full-bloom/
 *
 * TODO(Abhi) - To revisit
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 836 ms, faster than 66.67%
 * Memory Usage: 82.4 MB, less than 66.67%
 */
private fun fullBloomFlowers(flowers: Array<IntArray>, people: IntArray): IntArray {
    val sortedPeople = people.sorted()
    flowers.sortWith(compareBy({ it[0] }, { it[1] }))

    val map: MutableMap<Int, Int> = mutableMapOf()
    val priorityQueue: PriorityQueue<Int> = PriorityQueue<Int>()

    var i = 0
    for (person in sortedPeople) {
        // Add to queue if flower bloomed before or the time the person arrived
        while (i < flowers.size && flowers[i][0] <= person) {
            priorityQueue.add(flowers[i][1])
            i++
        }

        // Remove from queue if flower is not full bloomed anymore when the person arrives
        while (priorityQueue.isNotEmpty() && priorityQueue.peek() < person) {
            priorityQueue.remove()
        }

        map[person] = priorityQueue.size
    }

    val result = IntArray(people.size)
    people.forEachIndexed { index, value ->
        result[index] = map.getOrDefault(value, 0)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/number-of-flowers-in-full-bloom/
 *
 * Using map
 *
 * Stats
 * Time Limit Exceeded
 */
private fun fullBloomFlowersUsingMap(flowers: Array<IntArray>, people: IntArray): IntArray {
    val counter = mutableMapOf<Int, Int>()
    flowers.forEach {
        for (i in it[0]..it[1]) {
            counter[i] = counter.getOrDefault(i, 0) + 1
        }
    }
    val result = IntArray(people.size)
    people.forEachIndexed { index, value ->
        result[index] = counter.getOrDefault(value, 0)
    }
    return result
}

private fun main() {

}
