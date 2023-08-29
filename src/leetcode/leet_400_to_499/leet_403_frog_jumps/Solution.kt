package leetcode.leet_400_to_499.leet_403_frog_jumps

/**
 * leetcode - https://leetcode.com/problems/frog-jump/
 *
 * Using dynamic programming (tabulation), set and recursion
 *
 * Stats
 * Runtime: 456 ms, faster than 22.22%
 * Memory Usage: 55.5 MB, less than 11.11%
 */
private fun canCross(stones: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    val dp = mutableMapOf<Pair<Int,Int>, Boolean>()
    var result: Boolean
    stones.forEachIndexed { index, value ->
        map[value] = index
    }

    fun jump(position: Int, k: Int): Boolean {
        if (position == stones.lastIndex) {
            return true
        }
        if (dp.contains(Pair(position, k))) {
            return dp[Pair(position, k)] ?: false
        }

        val lessStep = if (k > 1 && map.contains(stones[position] + k - 1)) {
            jump(map[stones[position] + k - 1] ?: 0, k - 1)
        } else {
            false
        }
        val sameStep = if (k > 0 && map.contains(stones[position] + k)) {
            jump((map[stones[position] + k] ?: 0), k)
        } else {
            false
        }
        val additionalStep = if (map.contains(stones[position] + k + 1)) {
            jump((map[stones[position] + k + 1] ?: 0), k + 1)
        } else {
            false
        }
        result = lessStep || sameStep || additionalStep
        dp[Pair(position, k)] = result
        return result
    }
    return jump(0, 0)
}

private fun main() {

}
