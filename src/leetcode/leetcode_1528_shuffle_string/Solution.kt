package leetcode.leetcode_1528_shuffle_string

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/shuffle-string/
 *
 * Using char array
 *
 * Stats
 * Runtime: 434 ms, faster than 32.73%
 * Memory Usage: 45.2 MB, less than 38.18%
 */
private fun restoreStringUsingCharArray(s: String, indices: IntArray): String {
    val chars = CharArray(indices.size)
    for (i in indices.indices) {
        chars[indices[i]] = s[i]
    }
    return chars.joinToString("")
}


/**
 * leetcode - https://leetcode.com/problems/shuffle-string/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 234 ms, faster than 90.91%
 * Memory Usage: 40.8 MB, less than 69.09%
 */
private data class Data(
    val pos: Int,
    val char: Char
)

fun restoreString(s: String, indices: IntArray): String {
    val comparator = Comparator { d1: Data, d2: Data ->
        d1.pos - d2.pos
    }
    val priorityQueue = PriorityQueue(comparator)
    s.forEachIndexed { index, char ->
        priorityQueue.offer(Data(indices[index], char))
    }
    val stringBuilder = StringBuilder()
    while (priorityQueue.isNotEmpty()) {
        stringBuilder.append(priorityQueue.poll().char)
    }
    return stringBuilder.toString()
}

private fun main() {

}
