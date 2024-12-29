package leetcode.leetcode_823_binary_trees_with_factors

/**
 * leetcode - https://leetcode.com/problems/binary-trees-with-factors/
 *
 * TODO(Abhi) - To revisit
 *
 * Using dynamic programming
 *
 * Stats
 * Runtime: 234 ms, faster than 100.00%
 * Memory Usage: 37.4 MB, less than 100.00%
 */
private fun numFactoredBinaryTrees(arr: IntArray): Int {
    val mod = 1000000007
    arr.sort()
    val dp = Array(arr.size) { 1L }
    val index: MutableMap<Int?, Int?> = mutableMapOf()
    for (i in arr.indices) {
        index[arr[i]] = i
    }
    for (i in arr.indices) {
        for (j in 0..<i) {
            if (arr[i] % arr[j] == 0) {
                val right = arr[i] / arr[j]
                if (index.containsKey(right)) {
                    dp[i] = (dp[i] + dp[j] * dp[index[right]!!]) % mod
                }
            }
        }
    }
    var ans: Long = 0
    for (x in dp) ans += x
    return (ans % mod).toInt()
}

private fun main() {

}
