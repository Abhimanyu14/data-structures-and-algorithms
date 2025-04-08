package leetcode.leetcode_735_asteroid_collision

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/asteroid-collision/
 *
 * Data Structure - [ArrayDeque] (Stack)
 * Algorithm - Stacking
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
private fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    stack.addLast(asteroids[0])
    for (i in 1..asteroids.lastIndex) {
        var shouldAdd = true
        while (stack.isNotEmpty() && stack.last() > 0 && asteroids[i] < 0) {
            if (abs(stack.last()) == abs(asteroids[i])) {
                stack.removeLast()
                shouldAdd = false
                break
            } else if (abs(stack.last()) > abs(asteroids[i])) {
                shouldAdd = false
                break
            } else {
                stack.removeLast()
            }
        }
        if (shouldAdd) {
            stack.addLast(asteroids[i])
        }
    }
    return stack.toIntArray()
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
