package leetcode.leetcode_636_exclusive_time_of_functions

/**
 * leetcode - https://leetcode.com/problems/exclusive-time-of-functions/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [ArrayDeque] (Stack)
 * Algorithm -
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
private fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val result = IntArray(n)
    val stack = ArrayDeque<Triple<Int, Int, Int>>() // id, event, time: event 0-start 1-pause 2-resume
    for (log in logs) {
        val (id, event, timestamp) = log.split(":")
        if (event == "start") {
            if (stack.isNotEmpty()) {
                stack.addLast(Triple(stack.last().first, 1, timestamp.toInt() - 1))
            }
            stack.addLast(Triple(id.toInt(), 0, timestamp.toInt()))
        } else {
            var time = 0
            var lastEvent = timestamp.toInt()
            while (stack.isNotEmpty() && stack.last().second != 0) {
                val (_, poppedEvent, poppedTimestamp) = stack.removeLast()
                if (poppedEvent == 2) {
                    time += (lastEvent - poppedTimestamp + 1)
                } else {
                    lastEvent = poppedTimestamp
                }
            }
            time += (lastEvent - stack.removeLast().third + 1)
            result[id.toInt()] += time

            if (stack.isNotEmpty()) {
                stack.addLast(Triple(stack.last().first, 2, timestamp.toInt() + 1))
            }
        }
    }
    return result
}

private fun main() {

}
