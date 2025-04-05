package leetcode.leetcode_710_random_pick_with_blacklist

import kotlin.random.Random

/**
 * leetcode -
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private class Solution(n: Int, blacklist: IntArray) {
    private val sampleSize = n - blacklist.size
    private val sortedBlacklist = blacklist.sorted()

    fun pick(): Int {
        var random = Random.nextInt(sampleSize)
        var i = 0
        while (i <= sortedBlacklist.lastIndex && sortedBlacklist[i] <= random) {
            i++
            random++
        }
        return random
    }
}

private fun main() {

}
