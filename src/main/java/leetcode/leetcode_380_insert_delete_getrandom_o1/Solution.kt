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
private class RandomizedSetUsingElementAtMethod() {
    private val set = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    fun getRandom(): Int {
        return set.elementAt(Random.nextInt(set.size))
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
