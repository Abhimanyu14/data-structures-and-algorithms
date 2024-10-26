package leetcode.leet_1300_to_1399.leet_1310_xor_queries_of_a_subarray

/**
 * leetcode - https://leetcode.com/problems/xor-queries-of-a-subarray/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
    val result = IntArray(queries.size)
    // Process each query
    for (i in queries.indices) {
        var xorSum = 0
        // Calculate XOR for the range [q[0], q[1]]
        for (j in queries[i][0]..queries[i][1]) {
            xorSum = xorSum xor arr[j]
        }
        result[i] = xorSum
    }
    return result
}

private fun main() {

}
