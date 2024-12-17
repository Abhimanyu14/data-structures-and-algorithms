package leetcode.leetcode_2182_construct_string_with_repeat_limit

import java.util.PriorityQueue
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/construct-string-with-repeat-limit/?envType=daily-question&envId=2024-12-17
 *
 * Data Structure - [PriorityQueue], [Map] and [StringBuilder]
 * Algorithm - Counting, Heapify and String Building
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 159 ms, faster than 28.57%
 * Memory Usage: 50.2 MB, less than 5.56%
 *
 * Time -
 * Space -
 */
private fun repeatLimitedString(s: String, repeatLimit: Int): String {
    val result = StringBuilder()
    val counter = mutableMapOf<Char, Int>()
    for (char in s) {
        counter[char] = counter.getOrDefault(char, 0) + 1
    }
    val priorityQueue = PriorityQueue<Pair<Char, Int>> { a, b ->
        b.first.compareTo(a.first)
    }
    for ((key, value) in counter) {
        priorityQueue.offer(Pair(key, value))
    }
    var next: Pair<Char, Int>
    var current: Pair<Char, Int>? = priorityQueue.poll()
    while (current != null) {
        for (i in 0..<min(current.second, repeatLimit)) {
            result.append(current.first)
        }
        if (priorityQueue.isEmpty()) {
            break
        }
        if (current.second > repeatLimit) {
            next = priorityQueue.poll()
            result.append(next.first)
            if (next.second > 1) {
                priorityQueue.offer(Pair(next.first, next.second - 1))
            }
            current = Pair(current.first, current.second - min(current.second, repeatLimit))
        } else {
            current = priorityQueue.poll()
        }
    }
    return result.toString()
}

private fun main() {

}
