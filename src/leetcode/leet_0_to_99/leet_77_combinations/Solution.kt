package leetcode.leet_0_to_99.leet_77_combinations

/**
 * leetcode - https://leetcode.com/problems/combinations/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 404 ms, faster than 19.70%
 * Memory Usage: 45.2 MB, less than 13.64%
 */
private fun combineRecursion(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun getCombination(start: Int, currentList: List<Int>) {
        if (start > n) {
            return
        }
        if (currentList.size == k) {
            result.add(currentList)
        } else {
            for (i in (start + 1)..n) {
                getCombination(i, currentList + i)
            }
        }
    }
    getCombination(0, emptyList())
    return result
}

/**
 * leetcode - https://leetcode.com/problems/combinations/
 *
 * Using backtracking
 *
 * Stats
 */
fun combine(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun backtrack(curr: MutableList<Int>, firstNum: Int) {
        if (curr.size == k) {
            result.add(curr.toList())
            return
        }
        for (num in firstNum..n) {
            curr.add(num)
            backtrack(curr, num + 1)
            curr.removeAt(curr.size - 1)
        }
        return
    }
    backtrack(mutableListOf(), 1)
    return result
}

/**
 * leetcode - https://leetcode.com/problems/combinations/
 *
 * Using backtracking optimized
 *
 * Stats
 */
fun combineOptimized(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun backtrack(curr: MutableList<Int>, firstNum: Int) {
        if (curr.size == k) {
            result.add(curr.toList())
            return
        }
        val available = (n - firstNum + 1) - (k - curr.size)
        for (num in firstNum..firstNum + available) {
            curr.add(num)
            backtrack(curr, num + 1)
            curr.removeAt(curr.size - 1)
        }
        return
    }
    backtrack(mutableListOf(), 1)
    return result
}
