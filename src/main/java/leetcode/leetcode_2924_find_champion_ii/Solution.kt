package leetcode.leetcode_2924_find_champion_ii

/**
 * leetcode - https://leetcode.com/problems/find-champion-ii/?envType=daily-question&envId=2024-11-26
 *
 * Using set
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 19 ms, faster than 16.67%
 * Memory Usage: 59.4 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun findChampion(n: Int, edges: Array<IntArray>): Int {
    val set = mutableSetOf<Int>()
    repeat(n) {
        set.add(it)
    }
    edges.forEach {
        set.remove(it[1])
    }
    return if (set.size == 1) {
        set.first()
    } else {
        -1
    }
}

private fun main() {

}
