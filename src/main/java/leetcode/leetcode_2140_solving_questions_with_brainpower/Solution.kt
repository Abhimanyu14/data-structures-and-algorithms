package leetcode.leetcode_2140_solving_questions_with_brainpower

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-01
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Dynamic Programming - Memoization (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon
 */
private fun mostPointsUsingMemoization(questions: Array<IntArray>): Long {
    val cache = LongArray(questions.size)
    fun getMaxPoints(index: Int): Long {
        if (index > questions.lastIndex) {
            return 0
        }
        if (cache[index] > 0) {
            return cache[index]
        }
        cache[index] = max(
            getMaxPoints(index + 1),
            questions[index][0] + getMaxPoints(index + questions[index][1] + 1),
        )
        return cache[index]
    }
    return getMaxPoints(0)
}

/**
 * leetcode - https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-01
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Backtracking (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon
 */
private fun mostPointsUsingBacktracking(questions: Array<IntArray>): Long {
    fun getMaxPoints(index: Int): Long {
        if (index > questions.lastIndex) {
            return 0
        }
        return max(
            getMaxPoints(index + 1),
            questions[index][0] + getMaxPoints(index + questions[index][1] + 1),
        )
    }
    return getMaxPoints(0)
}

/**
 * leetcode - https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-01
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Amazon
 */
private fun mostPointsUsingRecursion(questions: Array<IntArray>): Long {
    fun getMaxPoints(index: Int, pointsSoFar: Long): Long {
        if (index > questions.lastIndex) {
            return pointsSoFar
        }
        return max(
            getMaxPoints(index + 1, pointsSoFar),
            getMaxPoints(index + questions[index][1] + 1, pointsSoFar + questions[index][0]),
        )
    }
    return getMaxPoints(0, 0L)
}

private fun main() {

}
