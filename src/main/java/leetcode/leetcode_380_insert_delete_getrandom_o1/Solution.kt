package leetcode.leetcode_380_insert_delete_getrandom_o1

import kotlin.random.Random

/**
 * leetcode - https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=problem-list-v2&envId=randomized
 *
 * Data Structure - [Random], [Set]
 * Algorithm - Randomization, Set
 *
 * Set operators - [insert], [remove], [random]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class RandomizedSet() {
    val map = mutableMapOf<Int, Int>()
    val list = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (map.contains(`val`)) {
            return false
        }
        list.add(`val`)
        map[`val`] = list.lastIndex
        return true
    }

    fun remove(`val`: Int): Boolean {
        val indexOfItemToRemove = map[`val`] ?: return false

        // Swap item to remove with last item and update map
        list[indexOfItemToRemove] = list.last()
        map[list.last()] = indexOfItemToRemove

        // Remove item from map and list
        map.remove(`val`) // O(1)
        list.removeLast() // O(1)
        return true
    }

    fun getRandom(): Int {
        return list[Random.nextInt(list.size)]
    }
}

private class RandomizedSetUsingElementAtMethod() {
    private val set = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    fun getRandom(): Int {
        return set.elementAt(Random.nextInt(set.size)) // O(N)
    }
}

/**
 * leetcode - https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=problem-list-v2&envId=randomized
 *
 * Data Structure - [Set]
 * Algorithm - Randomization, Set
 *
 * Set operators - [insert], [remove], [random]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class RandomizedSetUsingRandomMethod() {
    private val set = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    fun getRandom(): Int {
        return set.random()
    }
}

private fun main() {

}
