package leetcode.leetcode_1600_to_1699.leetcode_1647_minimum_deletions_to_make_character_frequencies_unique

import java.util.PriorityQueue
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * Using
 *
 * Stats
 */
private fun minDeletions(s: String): Int {
    var result = 0
    val sorted = s.toList().sortedDescending()
    var prev = sorted[0]
    var prevMax = 1
    var currentMax = 0
    var i = 0
    while (i < sorted.size && sorted[i] == prev) {
        prevMax++
        i++
    }
    println("sorted - ${sorted}")
    println("prev - ${prev}")
    println("prevMax - ${prevMax}")
    println()
    while (i < sorted.size) {
        if (sorted[i] == prev) {
            if (currentMax < prevMax) {
                currentMax++
            } else {
                result++
            }
        } else {
            currentMax = 1
            prev = sorted[i]
        }
        i++
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * Using map and priority queue
 *
 * Stats
 * Runtime: 359 ms, faster than 40.00%
 * Memory Usage: 39.6 MB, less than 40.00%
 */
private fun minDeletionsUsingPriorityQueue(s: String): Int {
    val counter = mutableMapOf<Char, Int>()
    s.forEach {
        counter[it] = (counter[it] ?: 0) + 1
    }

    val pq = PriorityQueue<Int> { a, b ->
        b - a
    }
    counter.forEach { (_, value) ->
        pq.offer(value)
    }

    var result = 0
    var currentMax = pq.poll()
    var temp: Int
    while (pq.isNotEmpty()) {
        temp = pq.poll()
        if (temp < currentMax) {
            currentMax = temp
        } else {
            result += min(temp, temp - (currentMax - 1))
            if (currentMax > 0) {
                currentMax--
            }
        }
    }
    return result
}

private fun main() {
    println(minDeletions("aaabbbcc"))
    println(minDeletions("ceabaacb"))
    println(minDeletions("aab"))
    println(minDeletions("bbcebab"))
}
