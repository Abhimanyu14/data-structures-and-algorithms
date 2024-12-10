package leetcode.leetcode_70_climbing_stairs

/**
 * leetcode - https://leetcode.com/problems/climbing-stairs/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Array
 * Algorithm - Pointers
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 33.9 MB, less than 20.70%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun climbStairs(n: Int): Int {
    if (n <= 2) {
        return n
    }
    var prev = 1
    var current = 2
    var temp: Int
    repeat(n - 2) {
        temp = current
        current += prev
        prev = temp
    }
    return current
}

/**
 * leetcode - https://leetcode.com/problems/climbing-stairs/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Array
 * Algorithm - Dynamic Programming (Tabulation)
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34 MB, less than 16.94%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun climbStairsUsingDp(n: Int): Int {
    if (n <= 2) {
        return n
    }
    val result = IntArray(n)
    result[0] = 1
    result[1] = 2
    for (i in 2..<n) {
        result[i] = result[i - 1] + result[i - 2]
    }
    return result[n - 1]
}

private fun main() {

}
