package leetcode.leetcode_1064_fixed_point

/**
 * leetcode - https://leetcode.com/problems/fixed-point/description/
 *
 * TODO(Abhi) - To revisit with Binary Search
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun fixedPoint(arr: IntArray): Int {
    for (i in arr.indices) {
        if (i == arr[i]) {
            return i
        }
    }
    return -1
}

private fun main() {

}
