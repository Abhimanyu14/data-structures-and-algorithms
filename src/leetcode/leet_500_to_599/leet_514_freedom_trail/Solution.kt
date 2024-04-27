package leetcode.leet_500_to_599.leet_514_freedom_trail

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/freedom-trail/?envType=daily-question&envId=2024-04-27
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun findRotateSteps(ring: String, key: String): Int {
    val ringLen = ring.length
    val keyLen = key.length

    // HashMap to store the indices of occurrences of each character in the ring
    val characterIndices: MutableMap<Char, MutableList<Int>> = HashMap()
    for (i in ring.indices) {
        val ch = ring[i]
        characterIndices.computeIfAbsent(
            ch
        ) { _: Char? -> ArrayList() }.add(i)
    }

    // Initialize the min heap (priority queue) with the starting point
    // Each element of the heap is an array of integers representing:
    // totalSteps, ringIndex, keyIndex
    val heap = PriorityQueue(Comparator.comparingInt { a: IntArray -> a[0] })

    heap.offer(intArrayOf(0, 0, 0))

    // HashSet to keep track of visited states
    val seen: MutableSet<Pair<Int, Int>> = HashSet()

    // Spell the keyword using the metal dial
    var totalSteps = 0
    while (!heap.isEmpty()) {
        // Pop the element with the smallest total steps from the heap
        val state = heap.poll()
        totalSteps = state[0]
        val ringIndex = state[1]
        val keyIndex = state[2]

        // We have spelled the keyword
        if (keyIndex == keyLen) {
            break
        }

        // Continue if we have visited this character from this position in ring before
        val currentState = Pair(ringIndex, keyIndex)
        if (seen.contains(currentState)) {
            continue
        }

        // Otherwise, add this pair to the visited list
        seen.add(currentState)

        // Add the rest of the occurrences of this character in ring to the heap
        for (nextIndex in characterIndices[key[keyIndex]]!!) {
            heap.offer(
                intArrayOf(
                    totalSteps + countSteps(ringIndex, nextIndex, ringLen),
                    nextIndex, keyIndex + 1
                )
            )
        }
    }

    // Return the total steps and add keyLen to account for
    // pressing the center button for each character in the keyword
    return totalSteps + keyLen
}

// Find the minimum steps between two indexes of ring
private fun countSteps(curr: Int, next: Int, ringLen: Int): Int {
    val stepsBetween = abs(curr - next)
    val stepsAround = ringLen - stepsBetween
    return min(stepsBetween, stepsAround)
}

private fun main() {

}
