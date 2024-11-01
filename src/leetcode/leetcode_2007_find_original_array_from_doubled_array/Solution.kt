package leetcode.leetcode_2007_find_original_array_from_doubled_array

/**
 * leetcode - https://leetcode.com/problems/find-original-array-from-doubled-array/
 *
 * Using soring, map and list
 *
 * Stats
 * Runtime: 1476 ms, faster than 33.33%
 * Memory Usage: 61.6 MB, less than 6.67%
 */
private fun findOriginalArray(changed: IntArray): IntArray {
    if (changed.size % 2 == 1) {
        return intArrayOf()
    }
    val sorted = changed.sorted()
    val map = mutableMapOf<Int, Int>()
    val result = mutableListOf<Int>()
    sorted.forEach {
        if (map.getOrDefault(it, 0) > 0) {
            if (map.getOrDefault(it, 0) == 1) {
                map.remove(it)
            } else {
                map[it] = map.getOrDefault(it, 0) - 1
            }
            result.add(it / 2)
        } else {
            map[it * 2] = map.getOrDefault(it * 2, 0) + 1
        }
    }
    return if (map.isEmpty()) {
        result.toIntArray()
    } else {
        intArrayOf()
    }
}

private fun main() {

}
