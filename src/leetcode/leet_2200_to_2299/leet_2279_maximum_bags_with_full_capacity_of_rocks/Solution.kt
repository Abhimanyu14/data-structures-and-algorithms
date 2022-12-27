package leetcode.leet_2200_to_2299.leet_2279_maximum_bags_with_full_capacity_of_rocks

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 *
 * Using array and sorting
 *
 * Stats
 * Runtime: 595 ms, faster than 100.00%
 * Memory Usage: 48.7 MB, less than 100.00%
 */
private fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
    val current = IntArray(capacity.size)
    current.forEachIndexed { index, _ ->
        current[index] = capacity[index] - rocks[index]
    }
    current.sort()
    var rocksLeft = additionalRocks
    var i = 0
    while (i < capacity.size && rocksLeft > 0) {
        val toRemove = min(current[i], rocksLeft)
        current[i] -= toRemove
        rocksLeft -= toRemove
        if (current[i] == 0) {
            i++
        }
    }
    if (i < capacity.size && current[i] == 0) {
        i++
    }
    return i
}

private fun main() {
    println(maximumBags(intArrayOf(2, 3, 4, 5), intArrayOf(1, 2, 4, 4), 2))
    println(maximumBags(intArrayOf(10, 2, 2), intArrayOf(2, 2, 0), 100))
}
