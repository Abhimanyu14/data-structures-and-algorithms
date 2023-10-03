package leetcode.leet_1500_to_1599.leet_1512_number_of_good_pairs

/**
 * leetcode - https://leetcode.com/problems/number-of-good-pairs/
 *
 * Using map
 *
 * Stats
 * Runtime: 137 ms, faster than 67.11%
 * Memory Usage: 33.9 MB, less than 34.87%
 */
private fun numIdenticalPairs(nums: IntArray): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    nums.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    counter.forEach { (_, value) ->
        if (value >= 2) {
            result += (value * (value - 1)) / 2
        }
    }
    return result
}

private fun main() {

}
