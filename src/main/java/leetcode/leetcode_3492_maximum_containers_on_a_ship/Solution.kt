package leetcode.leetcode_3492_maximum_containers_on_a_ship

/**
 * leetcode - https://leetcode.com/problems/maximum-containers-on-a-ship/description/
 *
 * Data Structure - NA
 * Algorithm - Maths
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun maxContainers(n: Int, w: Int, maxWeight: Int): Int {
    if (n * n * w <= maxWeight) {
        return n * n
    }
    return maxWeight / w
}

private fun main() {

}
