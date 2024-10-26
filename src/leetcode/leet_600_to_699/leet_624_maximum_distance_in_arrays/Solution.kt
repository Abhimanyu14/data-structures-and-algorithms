package leetcode.leet_600_to_699.leet_624_maximum_distance_in_arrays

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/maximum-distance-in-arrays/
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
private fun maxDistance(arrays: List<List<Int>>): Int {
    var res = 0
    var n: Int
    var minVal = arrays[0][0]
    var maxVal = arrays[0][arrays[0].size - 1]

    for (i in arrays.indices.drop(1)) {
        n = arrays[i].size
        res = maxOf(res, maxOf(abs(arrays[i][n - 1] - minVal),
            abs(maxVal - arrays[i][0])))
        minVal = minOf(minVal, arrays[i][0])
        maxVal = maxOf(maxVal, arrays[i][n - 1])
    }

    return res
}

private fun main() {

}
