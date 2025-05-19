package leetcode.leetcode_3250_find_the_count_of_monotonic_pairs_i

/**
 * leetcode - https://leetcode.com/problems/find-the-count-of-monotonic-pairs-i/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map]
 * Algorithm - Recursion, Dynamic Programming - Memoization
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private const val MOD = 1_000_000_007
private fun countOfPairs(nums: IntArray): Int {
    var result = 0L
    val cache = mutableMapOf<Triple<Int, Int, Int>, Int>()
    fun generate(index: Int, l1: Int, l2: Int): Int {
        if (index == nums.size) {
            return 1
        }
        cache[Triple(index, l1, l2)]?.let {
            return it
        }
        var count = 0
        for (i in l1..nums[index]) {
            if (nums[index] - i <= l2) {
                count = (count + generate(index + 1, i, nums[index] - i)) % MOD
            }
        }
        cache[Triple(index, l1, l2)] = count % MOD
        return cache[Triple(index, l1, l2)]!!
    }
    for (i in 0..nums[0]) {
        result = (result + generate(1, i, nums[0] - i)) % MOD
    }
    return result.toInt()
}

private fun main() {

}
