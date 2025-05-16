package leetcode.leetcode_1094_car_pooling

/**
 * leetcode - https://leetcode.com/problems/car-pooling/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * Data Structure - [SortedMap]
 * Algorithm - Line Sweep
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta
 */
private fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    val map = sortedMapOf<Int, Int>()
    for ((no, from, to) in trips) {
        map[from] = map.getOrDefault(from, 0) + no
        map[to] = map.getOrDefault(to, 0) - no
    }
    var current = 0
    for ((_,value) in map) {
        current += value
        if (current > capacity) {
            return false
        }
    }
    return true
}

private fun main() {

}
