package leetcode.leet_1100_to_1199.leet_1146_snapshot_array

import java.util.TreeMap

/**
 * leetcode - https://leetcode.com/problems/snapshot-array/
 *
 * Using TreeMap
 * Method - floorEntry()
 *
 * Stats
 * Runtime: 899 ms, faster than 56.67%
 * Memory Usage: 100.6 MB, less than 33.33%
 */

private class SnapshotArray(length: Int) {
    private var snapId = 0
    private var data = Array(length) {
        TreeMap<Int, Int>().apply {
            this[0] = 0
        }
    }

    operator fun set(index: Int, `val`: Int) {
        data[index][snapId] = `val`
    }

    fun snap(): Int {
        return snapId++
    }

    operator fun get(index: Int, snapId: Int): Int {
        return data[index].floorEntry(snapId).value
    }
}

private fun main() {

}
