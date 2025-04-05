package leetcode.leetcode_398_random_pick_index

import kotlin.random.Random

/**
 * leetcode - https://leetcode.com/problems/random-pick-index/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Random]
 * Algorithm - Randomization
 *
 * Random methods - [Random.nextInt]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class Solution(nums: IntArray) {
    val map = mutableMapOf<Int, MutableList<Int>>()

    init {
        for (i in nums.indices) {
            map.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }
    }

    fun pick(target: Int): Int {
        val indices = map[target].orEmpty()
        val random = Random.nextInt(indices.size)
        return indices[random]
    }
}

private fun main() {

}
