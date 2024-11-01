package leetcode.leetcode_700_to_799.leetcode_735_asteroid_collision

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

/**
 * leetcode - https://leetcode.com/problems/asteroid-collision/
 *
 * Using stack - deque
 *
 * Stats
 * Runtime: 260 ms, faster than 39.44%
 * Memory Usage: 40.5 MB, less than 30.00%
 */
private fun asteroidCollisionFunctionalProgramming(asteroids: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    asteroids.forEach { asteroid ->
        while (stack.isNotEmpty() && (asteroid < 0 && stack.last() > 0)) {
            if (abs(stack.last()) == abs(asteroid)) {
                stack.removeLast()
                return@forEach
            } else if (abs(stack.last()) < abs(asteroid)) {
                stack.removeLast()
            } else {
                return@forEach
            }
        }
        stack.addLast(asteroid)
    }
    return stack.toIntArray()
}

private fun main() {
    println(asteroidCollision(intArrayOf(5, 10, -5)).joinToString(", "))
    println(asteroidCollision(intArrayOf(8, -8)).joinToString(", "))
    println(asteroidCollision(intArrayOf(10, 2, -5)).joinToString(", "))
}
