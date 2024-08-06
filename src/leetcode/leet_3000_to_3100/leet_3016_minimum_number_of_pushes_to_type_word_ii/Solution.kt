package leetcode.leet_3000_to_3100.leet_3016_minimum_number_of_pushes_to_type_word_ii

import java.util.PriorityQueue


/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minimumPushes(word: String): Int {
    // Frequency map to store count of each letter
    val frequencyMap: MutableMap<Char, Int> = HashMap()

    // Count occurrences of each letter
    for (c in word.toCharArray()) {
        frequencyMap[c] = frequencyMap.getOrDefault(c, 0) + 1
    }

    // Priority queue to store frequencies in descending order
    val frequencyQueue = PriorityQueue { a: Int, b: Int -> b - a }
    frequencyQueue.addAll(frequencyMap.values)

    var totalPushes = 0
    var index = 0

    // Calculate total number of presses
    while (!frequencyQueue.isEmpty()) {
        totalPushes += (index / 8 + 1) * frequencyQueue.poll()
        index++
    }

    return totalPushes
}

private fun main() {

}
