package leetcode.leetcode_398_random_pick_index

import kotlin.random.Random

/**
 * leetcode - https://leetcode.com/problems/random-pick-index/description/
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
    private val indexMap = mutableMapOf<Int, MutableList<Int>>()

    init {
        for (i in nums.indices) {
            indexMap.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }
    }

    fun pick(target: Int): Int {
        return indexMap.getOrDefault(target, emptyList())[Random.nextInt(indexMap[target]?.size ?: 0)]
    }
}

private fun main() {

}
