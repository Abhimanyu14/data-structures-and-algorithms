package leetcode.leetcode_755_pour_water

// TODO-Abhi: To implement using DP and other approaches
/**
 * leetcode - https://leetcode.com/problems/pour-water/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 322 ms, faster than 33.33%
 * Memory Usage: 37.1 MB, less than 33.33%
 */
private fun pourWater(heights: IntArray, volume: Int, k: Int): IntArray {
    var p: Int
    var drop: Int
    for (i in 1..volume) {
        p = k
        drop = k
        while (p > 0 && heights[p] >= heights[p - 1]) {
            p--
            if (heights[drop] > heights[p]) {
                drop = p
            }
        }
        if (drop != k) {
            heights[drop]++
            continue
        }
        drop = k
        while (p < heights.lastIndex && heights[p] >= heights[p + 1]) {
            p++
            if (heights[drop] > heights[p]) {
                drop = p
            }
        }
        heights[drop]++
    }
    return heights
}

private fun main() {
    println(pourWater(intArrayOf(1, 2, 3, 4), 2, 2).joinToString(", "))
}
