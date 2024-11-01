package leetcode.leetcode_900_to_999.leetcode_950_reveal_cards_in_increasing_order

import java.util.Arrays
import java.util.LinkedList
import java.util.Queue



/**
 * leetcode - https://leetcode.com/problems/reveal-cards-in-increasing-order/?envType=daily-question&envId=2024-04-10
 *
 * Using queue
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 193 ms, faster than 100.00%
 * Memory Usage: 38.2 MB, less than 66.67%
 *
 * Time - O(N log N)
 * Space - O(N)
 */
private fun deckRevealedIncreasing(deck: IntArray): IntArray {
    val queue: Queue<Int> = LinkedList()

    // Create a queue of indexes
    for (i in deck.indices) {
        queue.add(i)
    }
    deck.sort()
    // Put cards at correct index in result
    val result = IntArray(deck.size)
    for (i in deck.indices) {
        // Reveal Card and place in result
        result[queue.poll()] = deck[i]

        // Move next card to bottom
        queue.add(queue.poll())
    }
    return result
}

private fun main() {

}
