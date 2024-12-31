package leetcode.leetcode_705_design_hashset

/**
 * leetcode - https://leetcode.com/problems/design-hashset/description/
 *
 * Data Structure - BooleanArray
 * Algorithm - Design
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space - O(10 ^ 6)
 */
private class MyHashSet() {
    private val set = BooleanArray(1_000_001)

    // Time - O(1)
    fun add(key: Int) {
        set[key] = true
    }

    // Time - O(1)
    fun remove(key: Int) {
        set[key] = false
    }

    // Time - O(1)
    fun contains(key: Int): Boolean {
        return set[key]
    }
}

/**
 * leetcode - https://leetcode.com/problems/design-hashset/description/
 *
 * Data Structure - List
 * Algorithm - Design
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space - O(N)
 */
private class MyHashSetUsingList() {
    private val set = mutableListOf<Int>()

    // Time - O(N)
    fun add(key: Int) {
        if (!contains(key)) {
            set.add(key)
        }
    }

    // Time - O(N)
    fun remove(key: Int) {
        set.remove(key)
    }

    // Time - O(N)
    fun contains(key: Int): Boolean {
        for (item in set) {
            if (item == key) {
                return true
            }
        }
        return false
    }
}

private fun main() {

}
