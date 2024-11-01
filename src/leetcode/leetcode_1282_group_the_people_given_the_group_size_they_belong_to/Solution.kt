package leetcode.leetcode_1282_group_the_people_given_the_group_size_they_belong_to

/**
 * leetcode - https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 *
 * Using list and map
 *
 * Stats
 * Runtime: 278 ms, faster than 40.00%
 * Memory Usage: 41.1 MB, less than 16.67%
 */
private fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val groupMap = mutableMapOf<Int, MutableList<Int>>()
    val result = mutableListOf<List<Int>>()
    groupSizes.forEachIndexed { index, value ->
        groupMap.computeIfAbsent(value) {
            mutableListOf()
        }.add(index)
        if (groupMap[value]?.size == value) {
            result.add(groupMap[value]?.toList().orEmpty())
            groupMap[value]?.clear()
        }
    }
    return result
}

private fun main() {

}
