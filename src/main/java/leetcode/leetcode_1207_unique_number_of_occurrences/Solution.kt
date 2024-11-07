package leetcode.leetcode_1207_unique_number_of_occurrences

/**
 * leetcode - https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * Using Hashmap and distinct
 *
 * Stats
 * Runtime: 303 ms, faster than 42.10%
 * Memory Usage: 35.9 MB, less than 28.95%
 */
private fun uniqueOccurrences(arr: IntArray): Boolean {
    val counter = HashMap<Int, Int>()
    arr.forEach {
        counter[it] = (counter[it] ?: 0) + 1
    }
    return counter.values.size == counter.values.distinct().size
}

/**
 * Using Hashmap and set
 *
 * Stats
 * Runtime: 338 ms, faster than 15.79%
 * Memory Usage: 36.4 MB, less than 18.42%
 */
private fun uniqueOccurrencesUsingSet(arr: IntArray): Boolean {
    val counter = HashMap<Int, Int>()
    arr.forEach {
        counter[it] = (counter[it] ?: 0) + 1
    }
    return counter.values.size == counter.values.toSet().size
}

private fun main() {

}
