package leetcode.leetcode_781_rabbits_in_forest

import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/problems/rabbits-in-forest/description/?envType=daily-question&envId=2025-04-20
 *
 * Data Structure - [Map]
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies -Amazon, Apple, Google
 */
private fun numRabbits(answers: IntArray): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    for (answer in answers) {
        if (counter.getOrDefault(answer, 0) == 0) {
            result += answer + 1
        }
        counter[answer] = counter.getOrDefault(answer, 0) + 1
        if (counter.getOrDefault(answer, 0) == answer + 1) {
            counter[answer] = 0
        }
    }
    return result
}

private fun numRabbitsUsingTwoPass(answers: IntArray): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    for (answer in answers) {
        counter[answer] = counter.getOrDefault(answer, 0) + 1
    }
    for ((key, value) in counter) {
        result += ceil(value / (key + 1.0)).toInt() * (key + 1)
    }
    return result
}

private fun main() {

}
