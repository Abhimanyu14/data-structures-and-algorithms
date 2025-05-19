package leetcode.leetcode_2534_time_taken_to_cross_the_door

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/time-taken-to-cross-the-door/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [PriorityQueue], [IntArray]
 * Algorithm - Heapify
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon, Google
 */
private fun timeTaken(arrival: IntArray, state: IntArray): IntArray {
    val result = IntArray(arrival.size)
    val entryQueue = ArrayDeque<Int>()
    val exitQueue = ArrayDeque<Int>()
    var lastIsEntry = false
    var lastTimestamp = -1

    var index = 0

    fun addToQueue() {
        val currentTime = if (entryQueue.isEmpty() && exitQueue.isEmpty()) {
            arrival[index]
        } else {
            lastTimestamp + 1
        }
        while (index <= arrival.lastIndex && arrival[index] == currentTime) {
            if (state[index] == 0) {
                entryQueue.addLast(index)
            } else {
                exitQueue.addLast(index)
            }
            index++
        }
    }

    fun processQueue(isEntry: Boolean) {
        val currentIndex = if (isEntry) {
            entryQueue.removeFirst()
        } else {
            exitQueue.removeFirst()
        }
        result[currentIndex] = if (arrival[currentIndex] > lastTimestamp + 1) {
            arrival[currentIndex]
        } else {
            lastTimestamp + 1
        }
        lastTimestamp = result[currentIndex]
        lastIsEntry = isEntry
    }

    fun processQueue() {
        if (entryQueue.isEmpty()) {
            processQueue(false)
        } else if (exitQueue.isEmpty()) {
            processQueue(true)
        } else {
            if (lastIsEntry && arrival[exitQueue.first()] <= lastTimestamp + 1) {
                processQueue(true)
            } else {
                processQueue(false)
            }
        }
    }

    while (index <= arrival.lastIndex) {
        addToQueue()
        processQueue()
    }
    while (entryQueue.isNotEmpty() || exitQueue.isNotEmpty()) {
        processQueue()
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/time-taken-to-cross-the-door/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [PriorityQueue], [IntArray]
 * Algorithm - Heapify
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon, Google
 */
private fun timeTakenUsingPriorityQueue(arrival: IntArray, state: IntArray): IntArray {
    val result = IntArray(arrival.size)
    val entryQueue = PriorityQueue<Pair<Int, Int>> { a, b -> // index, arrivalTime
        a.first - b.first
    }
    val exitQueue = PriorityQueue<Pair<Int, Int>> { a, b -> // index, arrivalTime
        a.first - b.first
    }
    var lastIsEntry = false
    var lastTimestamp = -1

    var index = 0

    fun addToQueue() {
        val currentTime = if (entryQueue.isEmpty() && exitQueue.isEmpty()) {
            arrival[index]
        } else {
            lastTimestamp + 1
        }
        while (index <= arrival.lastIndex && arrival[index] == currentTime) {
            if (state[index] == 0) {
                entryQueue.offer(Pair(index, arrival[index]))
            } else {
                exitQueue.offer(Pair(index, arrival[index]))
            }
            index++
        }
    }

    fun processQueue(isEntry: Boolean) {
        val (currentIndex, currentArrivalTime) = if (isEntry) {
            entryQueue.poll()
        } else {
            exitQueue.poll()
        }
        result[currentIndex] = if (currentArrivalTime > lastTimestamp + 1) {
            currentArrivalTime
        } else {
            lastTimestamp + 1
        }
        lastTimestamp = result[currentIndex]
        lastIsEntry = isEntry
    }

    fun processQueue() {
        if (entryQueue.isEmpty()) {
            processQueue(false)
        } else if (exitQueue.isEmpty()) {
            processQueue(true)
        } else {
            if (lastIsEntry && exitQueue.peek().second <= lastTimestamp + 1) {
                processQueue(true)
            } else {
                processQueue(false)
            }
        }
    }

    while (index <= arrival.lastIndex) {
        addToQueue()
        processQueue()
    }
    while (entryQueue.isNotEmpty() || exitQueue.isNotEmpty()) {
        processQueue()
    }
    return result
}

private fun main() {

}
