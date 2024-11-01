package leetcode.leetcode_1200_to_1299.leetcode_1220_count_vowels_permutation

/**
 * leetcode - https://leetcode.com/problems/count-vowels-permutation/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 624 ms, faster than 22.22%
 * Memory Usage: 87 MB, less than 11.11%
 */
private fun countVowelPermutation(n: Int): Int {
    val followedByMap = mapOf(
        ' ' to listOf('a', 'e', 'i', 'o', 'u'),
        'a' to listOf('e'),
        'e' to listOf('a', 'i'),
        'i' to listOf('a', 'e', 'o', 'u'),
        'o' to listOf('i', 'u'),
        'u' to listOf('a'),
    )
    val memo = mutableMapOf<Pair<Int, Char>, Long>()
    fun getCount(m: Int, prev: Char): Long {
        if (m == 0) {
            return 1L
        }
        memo[Pair(m, prev)]?.let {
            return it
        }
        var result = 0L
        followedByMap[prev]?.forEach {
            result = (result + getCount(m - 1, it)) % 1_000_000_007
        }
        memo[Pair(m, prev)] = result
        return result
    }

    return (getCount(n, ' ')).toInt()
}

private fun main() {

}
