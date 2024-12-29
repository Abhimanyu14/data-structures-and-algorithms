package leetcode.leetcode_1170_compare_strings_by_frequency_of_the_smallest_character

/**
 * leetcode - https://leetcode.com/classic/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * Data Structure - Arrays
 * Algorithm - Sorting and Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
    val result = IntArray(queries.size)
    fun f(str: String): Int {
        val counter = IntArray(26)
        for (char in str) {
            counter[char - 'a']++
        }
        for (i in 0..25) {
            if (counter[i] > 0) {
                return counter[i]
            }
        }
        return 0
    }
    val queriesF = IntArray(queries.size) {
        f(queries[it])
    }
    val wordsF = IntArray(words.size)
    for (i in words.indices) {
        wordsF[f(words[i])]++
    }
    fun getResultValue(num: Int): Int {
        var left = 0
        var right = wordsF.size
        while (left < right) {
            val mid = (left + ((right - left) / 2))
            if (wordsF[mid] > num) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
    for (i in queries.indices) {
        result[i] = wordsF.size - getResultValue(queriesF[i])
    }
    return result
}

/**
 * leetcode - https://leetcode.com/classic/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * Data Structure - Arrays
 * Algorithm - Sorting and Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun numSmallerByFrequencyUsingSorting(queries: Array<String>, words: Array<String>): IntArray {
    val result = IntArray(queries.size)
    fun f(str: String): Int {
        val counter = IntArray(26)
        for (char in str) {
            counter[char - 'a']++
        }
        for (i in 0..25) {
            if (counter[i] > 0) {
                return counter[i]
            }
        }
        return 0
    }
    val queriesF = IntArray(queries.size) {
        f(queries[it])
    }
    val wordsF = IntArray(words.size) {
        f(words[it])
    }
    wordsF.sort()
    fun getResultValue(num: Int): Int {
        var left = 0
        var right = wordsF.size
        while (left < right) {
            val mid = (left + ((right - left) / 2))
            if (wordsF[mid] > num) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
    for (i in queries.indices) {
        result[i] = wordsF.size - getResultValue(queriesF[i])
    }
    return result
}

private fun main() {

}
