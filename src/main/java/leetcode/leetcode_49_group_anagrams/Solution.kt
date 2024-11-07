package leetcode.leetcode_49_group_anagrams

/**
 * leetcode - https://leetcode.com/problems/group-anagrams/
 *
 * Using counting array
 *
 * Stats
 * Runtime: 377 ms, faster than 75.06%
 * Memory Usage: 44.2 MB, less than 65.74%
 */
private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()
    var counter: IntArray
    strs.forEach { string ->
        counter = IntArray(26)
        string.forEach {
            counter[it - 'a']++
        }
        val key = counter.joinToString(", ")
        result.computeIfAbsent(key) {
            mutableListOf()
        }.add(string)
    }
    return result.values.toList()
}

/**
 * leetcode - https://leetcode.com/problems/group-anagrams/
 *
 * Using sorting and map
 *
 * Stats
 * Runtime: 387 ms, faster than 70.53%
 * Memory Usage: 42.7 MB, less than 79.60%
 */
private fun groupAnagramsUsingSort(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()
    strs.forEach { string ->
        val sortedStrings = string.toCharArray().sorted().joinToString()
        result.computeIfAbsent(sortedStrings) {
            mutableListOf()
        }.add(string)
    }
    return result.values.toList()
}

private fun main() {

}
