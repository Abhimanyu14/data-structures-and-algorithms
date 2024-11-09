package leetcode.leetcode_1409_queries_on_a_permutation_with_key

import java.util.LinkedList

/**
 * leetcode - https://leetcode.com/problems/queries-on-a-permutation-with-key/description/
 *
 * Using [LinkedList]
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 8 ms, faster than 100.00%
 * Memory Usage: 37.7 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun processQueries(queries: IntArray, m: Int): IntArray {
    val result = IntArray(queries.size)
    val list = LinkedList<Int>()
    repeat(m) {
        list.add(it + 1)
    }
    queries.forEachIndexed { index, query ->
        result[index] = list.indexOf(query)
        val removed = list.removeAt(result[index])
        list.add(0, removed)
    }
    return result
}

private fun main() {

}
