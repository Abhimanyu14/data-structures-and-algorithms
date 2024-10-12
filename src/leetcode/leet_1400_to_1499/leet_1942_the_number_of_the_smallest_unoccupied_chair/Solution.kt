package leetcode.leet_1400_to_1499.leet_1942_the_number_of_the_smallest_unoccupied_chair

import java.util.Arrays
import java.util.PriorityQueue
import java.util.TreeSet


/**
 * leetcode - https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
    val targetArrival = times[targetFriend][0]
    Arrays.sort(times) { a: IntArray, b: IntArray ->
        a[0] - b[0]
    }
    var nextChair = 0
    val leavingQueue = PriorityQueue { a: IntArray, b: IntArray ->
        a[0] - b[0]
    }
    val availableChairs = TreeSet<Int>()
    times.forEach { time ->
        val arrival = time[0]
        val leave = time[1]

        // Free up chairs based on current time
        while (leavingQueue.isNotEmpty() && leavingQueue.peek()[0] <= arrival) {
            availableChairs.add(leavingQueue.poll()[1])
        }

        // Assign chair from available set or increment new chair
        val currentChair: Int = if (availableChairs.isNotEmpty()) {
            availableChairs.removeFirst()
        } else {
            nextChair++
        }

        // Push current leave time and chair
        leavingQueue.offer(intArrayOf(leave, currentChair))

        // Check if it's the target friend
        if (arrival == targetArrival) {
            return currentChair
        }
    }
    return 0
}

private fun main() {

}
