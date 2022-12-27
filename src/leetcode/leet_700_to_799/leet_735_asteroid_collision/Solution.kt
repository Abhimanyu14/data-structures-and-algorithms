package leetcode.leet_700_to_799.leet_735_asteroid_collision

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/asteroid-collision/
 *
 * Using stack - deque
 *
 * Stats
 * Runtime: 304 ms, faster than 85.29%
 * Memory Usage: 40 MB, less than 88.24%
 */
private fun asteroidCollision(asteroids: IntArray): IntArray {
    val deque = ArrayDeque<Int>()
    var toAdd: Int?
    var last: Int
    asteroids.forEach { asteroid ->
        toAdd = asteroid
        while (toAdd != null) {
            toAdd?.let {
                if (it < 0 && deque.isNotEmpty() && deque.last() > 0) {
                    last = deque.removeLast()
                    if (last == abs(it)) {
                        toAdd = null
                    } else if (last > abs(it)) {
                        deque.addLast(last)
                        toAdd = null
                    }
                } else {
                    deque.addLast(it)
                    toAdd = null
                }
            }
        }
    }
    return deque.toIntArray()
}

private fun main() {
    println(asteroidCollision(intArrayOf(5, 10, -5)).joinToString(", "))
    println(asteroidCollision(intArrayOf(8, -8)).joinToString(", "))
    println(asteroidCollision(intArrayOf(10, 2, -5)).joinToString(", "))
}
