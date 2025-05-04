package leetcode.leetcode_1128_number_of_equivalent_domino_pairs

/**
 * leetcode - https://leetcode.com/problems/number-of-equivalent-domino-pairs/submissions/1624976766/?envType=daily-question&envId=2025-05-04
 *
 * Data Structure - [Map]
 * Algorithm - Hashing and Counting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google
 */
private fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    var result = 0
    val counter = mutableMapOf<String, Int>()
    for (domino in dominoes) {
        if (domino[0] <= domino[1]) {
            counter["${domino[0]}#${domino[1]}"] = counter.getOrDefault("${domino[0]}#${domino[1]}", 0) + 1
        } else {
            counter["${domino[1]}#${domino[0]}"] = counter.getOrDefault("${domino[1]}#${domino[0]}", 0) + 1
        }
    }
    for ((_, value) in counter) {
        result += ((value - 1) * (value) / 2)
    }
    return result
}

private fun main() {

}
