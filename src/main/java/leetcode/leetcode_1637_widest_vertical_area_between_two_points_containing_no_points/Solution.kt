package leetcode.leetcode_1637_widest_vertical_area_between_two_points_containing_no_points

import java.util.TreeSet
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/?envType=daily-question&envId=2023-12-21
 *
 * Using [TreeSet]
 *
 * Stats
 * Runtime: 541 ms, faster than 100.00%
 * Memory Usage: 82.2 MB, less than 100.00%
 */
private fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
    val set = TreeSet<Int>()
    points.forEach {
        set.add(it[0])
    }
    if (set.size == 1) {
        return 0
    }
    val list = set.toList()
    var result = list[1] - list[0]
    for (i in 3..list.lastIndex) {
        result = max(result, list[i] - list[i - 1])
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/?envType=daily-question&envId=2023-12-21
 *
 * Using functional programming
 *
 * Stats
 * Runtime: 735 ms, faster than 100.00%
 * Memory Usage: 95 MB, less than 100.00%
 */
private fun maxWidthOfVerticalAreaFunctionalProgramming(points: Array<IntArray>): Int {
    return points.asSequence().map { it[0] }.distinct().sorted().zipWithNext().maxOfOrNull { (current, next) -> next - current } ?: 0
}

/**
 * leetcode - https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/?envType=daily-question&envId=2023-12-21
 *
 * Using set and sorting
 *
 * Stats
 * Runtime: 662 ms, faster than 100.00%
 * Memory Usage: 92.3 MB, less than 100.00%
 */
fun maxWidthOfVerticalAreaIterative(points: Array<IntArray>): Int {
    val xList = mutableSetOf<Int>()
    points.forEach {
        xList.add(it[0])
    }
    if (xList.size == 1) {
        return 0
    }
    val sorted = xList.toList().sorted()
    var result = sorted[1] - sorted[0]
    for (i in 3..sorted.lastIndex) {
        result = max(result, sorted[i] - sorted[i - 1])
    }
    return result
}

private fun main() {

}
