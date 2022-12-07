package leetcode.leet_900_to_999.leet_997_find_the_town_judge

/**
 * leetcode - https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Using hashset and hashmap
 *
 * Stats
 * Runtime: 1014 ms, faster than 32.81%
 * Memory Usage: 94 MB, less than 54.69%
 */
private fun findJudge(n: Int, trust: Array<IntArray>): Int {
    if (n == 1 && trust.isEmpty()) {
        return 1
    }
    val people = mutableSetOf<Int>()
    val keyTrustsValue = mutableMapOf<Int, MutableList<Int>>()
    val keyTrustedByValue = mutableMapOf<Int, MutableList<Int>>()
    trust.forEach {
        people.add(it[0])
        people.add(it[1])
        keyTrustsValue.computeIfAbsent(it[0]) {
            mutableListOf()
        }.add(it[1])
        keyTrustedByValue.computeIfAbsent(it[1]) {
            mutableListOf()
        }.add(it[0])
    }

    for (i in people) {
        if (keyTrustsValue.contains(i).not() && keyTrustedByValue.getOrDefault(i, mutableListOf()).size == people.size - 1) {
            return i
        }
    }
    return -1
}

/**
 * TODO-Abhi: Using two array and one array
 */
private fun main() {

}
