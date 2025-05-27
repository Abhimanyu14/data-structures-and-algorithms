package leetcode.leetcode_2924_find_champion_ii

/**
 * leetcode - https://leetcode.com/problems/find-champion-ii/?envType=daily-question&envId=2024-11-26
 *
 * Data Structure - [BooleanArray]
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * E: edges.size
 * N: n
 * Time - O(N + E)
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private fun findChampion(n: Int, edges: Array<IntArray>): Int {
    var result = -1
    val canLose = BooleanArray(n)
    for ((_, loses) in edges) {
        canLose[loses] = true
    }
    for (i in 0..<n) {
        if (!canLose[i]) {
            if (result == -1) {
                result = i
            } else {
                return -1
            }
        }
    }
    return result
}

private fun findChampionUsingSet(n: Int, edges: Array<IntArray>): Int {
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
