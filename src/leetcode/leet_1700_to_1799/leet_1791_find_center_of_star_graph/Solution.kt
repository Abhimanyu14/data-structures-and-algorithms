package leetcode.leet_1700_to_1799.leet_1791_find_center_of_star_graph

/**
 * leetcode - https://leetcode.com/problems/find-center-of-star-graph/
 *
 * Using conditions
 *
 * Stats
 * Runtime: 384 ms, faster than 89.13%
 * Memory Usage: 69.9 MB, less than 80.43%
 */
private fun findCenter(edges: Array<IntArray>): Int {
    return if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
        edges[0][0]
    } else {
        edges[0][1]
    }
}
private fun main() {

}
