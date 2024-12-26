package leetcode.leetcode_2079_watering_plants

/**
 * leetcode - https://leetcode.com/problems/watering-plants/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 38.7 MB, less than 0.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun wateringPlants(plants: IntArray, capacity: Int): Int {
    var result = 0
    var remaining = capacity
    for (i in plants.indices) {
        if (plants[i] > remaining) {
            result += ((i * 2) + 1)
            remaining = capacity - plants[i]
        } else {
            result++
            remaining -= plants[i]
        }
    }
    return result
}

private fun main() {

}
