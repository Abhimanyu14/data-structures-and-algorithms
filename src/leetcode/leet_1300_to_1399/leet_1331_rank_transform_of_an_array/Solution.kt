package leetcode.leet_1300_to_1399.leet_1331_rank_transform_of_an_array

/**
 * leetcode - https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * Using set and map
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 530 ms, faster than 78.95%
 * Memory Usage: 61.8 MB, less than 10.53%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun arrayRankTransform(arr: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    arr.toSortedSet().forEachIndexed { index, i ->
        map[i] = index + 1
    }
    for (i in arr.indices) {
        arr[i] = map[arr[i]] ?: 0
    }
    return arr
}

private fun main() {

}
