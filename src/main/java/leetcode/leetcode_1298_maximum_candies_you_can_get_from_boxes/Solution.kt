package leetcode.leetcode_1298_maximum_candies_you_can_get_from_boxes

import java.util.LinkedList

/**
 * leetcode - https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
 *
 * Data Structure - Queue and Set
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 77 ms, faster than 17.39%
 * Memory Usage: 60.1 MB, less than 86.96%
 *
 * Time -
 * Space -
 */
private fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {
    var result = 0
    val openBoxesQueue = LinkedList<Int>()
    val closedBoxes = mutableSetOf<Int>()
    val keysFound = mutableSetOf<Int>()
    for (box in initialBoxes) {
        if (status[box] == 1) {
            openBoxesQueue.offer(box)
        } else {
            closedBoxes.add(box)
        }
    }
    while (openBoxesQueue.isNotEmpty()) {
        val box = openBoxesQueue.poll()
        result += candies[box]
        keysFound.addAll(keys[box].toSet())
        val closedBoxIterator = closedBoxes.iterator()
        while (closedBoxIterator.hasNext()) {
            val closedBox = closedBoxIterator.next()
            if (keysFound.contains(closedBox)) {
                openBoxesQueue.offer(closedBox)
                closedBoxIterator.remove()
            }
        }
        for (containedBox in containedBoxes[box]) {
            if (keysFound.contains(containedBox) || status[containedBox] == 1) {
                openBoxesQueue.offer(containedBox)
            } else {
                closedBoxes.add(containedBox)
            }
        }
    }
    return result
}

private fun main() {
    val set = mutableSetOf(1,2,3,4,5)
    val setIterator = set.iterator()

    while (setIterator.hasNext()) {
        println(setIterator.next())
        println(setIterator.next())
    }

    println("$set")
}
