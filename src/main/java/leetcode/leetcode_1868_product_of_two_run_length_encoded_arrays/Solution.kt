package leetcode.leetcode_1868_product_of_two_run_length_encoded_arrays

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun findRLEArray(encoded1: Array<IntArray>, encoded2: Array<IntArray>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    var list1Index = Pair(0, 0) // index, processed count
    var list2Index = Pair(0, 0) // index, processed count
    var prev = mutableListOf<Int>()
    while (list1Index.first <= encoded1.lastIndex) {
        val value = (encoded1[list1Index.first][0] * encoded2[list2Index.first][0])
        val count = min(
            (encoded1[list1Index.first][1] - list1Index.second),
            (encoded2[list2Index.first][1] - list2Index.second)
        )
        if (prev.isEmpty()) {
            prev = mutableListOf(value, count)
        } else {
            if (prev[0] == value) {
                prev[1] += count
            } else {
                result.add(prev)
                prev = mutableListOf(value, count)
            }
        }
        list1Index = if (encoded1[list1Index.first][1] == list1Index.second + count) {
            Pair(list1Index.first + 1, 0)
        } else {
            Pair(list1Index.first, list1Index.second + count)
        }
        list2Index = if (encoded2[list2Index.first][1] == list2Index.second + count) {
            Pair(list2Index.first + 1, 0)
        } else {
            Pair(list2Index.first, list2Index.second + count)
        }
    }
    result.add(prev)
    return result
}

private fun main() {

}
