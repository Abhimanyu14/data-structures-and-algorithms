package leetcode.leetcode_700_to_799.leetcode_767_reorganize_string

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/reorganize-string/
 *
 * Using arrays, and priority queue
 *
 * Stats
 * Runtime: 158 ms, faster than 61.54%
 * Memory Usage: 35.9 MB, less than 30.77%
 */
data class CharCount(
    val char: Char,
    val count: Int = 0,
)

private fun reorganizeString(s: String): String {
    val priorityQueue = PriorityQueue<CharCount> { a, b ->
        b.count - a.count
    }
    val charCounter = IntArray(26) { 0 }
    s.forEach {
        charCounter[it - 'a']++
    }
    charCounter.forEachIndexed { index, value ->
        if (value != 0) {
            priorityQueue.add(CharCount('a' + index, value))
        }
    }
    val result = StringBuilder()
    var temp: CharCount
    var prev = CharCount('-', 0)
    while (priorityQueue.isNotEmpty()) {
        temp = priorityQueue.poll()
        result.append(temp.char)
        if (prev.count > 0) {
            priorityQueue.offer(prev)
        }
        prev = temp.copy(count = temp.count - 1)
    }
    if (prev.count != 0 && result.last() == prev.char) {
        return ""
    }
    return result.toString()
}

private fun main() {
    println(reorganizeString("aaab"))
    println(reorganizeString("aab"))
}
