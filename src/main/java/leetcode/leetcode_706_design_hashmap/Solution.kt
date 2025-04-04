package leetcode.leetcode_706_design_hashmap

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/design-hashmap/
 *
 * Using array
 *
 * Stats
 * Runtime: 394 ms, faster than 59.65%
 * Memory Usage: 63.8 MB, less than 15.79%
 */
private class MyHashMap() {
    val array = IntArray(10.0.pow(6).toInt() + 1) { -1 }

    fun put(key: Int, value: Int) {
        array[key] = value
    }

    fun get(key: Int): Int {
        return array[key]
    }

    fun remove(key: Int) {
        array[key] = -1
    }
}

private fun main() {

}
