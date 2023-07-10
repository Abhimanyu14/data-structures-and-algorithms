package leetcode.leet_0_to_99.leet_49_group_anagrams

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
    var count = IntArray(26)
    strs.forEach { str ->
        count = IntArray(26)
        str.forEach {
            count[it - 'a']++
        }
        val key = count.joinToString(", ")
        result.computeIfAbsent(key) {
            mutableListOf()
        }.add(str)
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
    strs.forEach { str ->
        val sortedStr = str.toCharArray().sorted().joinToString()
        result.computeIfAbsent(sortedStr) {
            mutableListOf()
        }.add(str)
    }
    return result.values.toList()
}

private fun main() {

}
