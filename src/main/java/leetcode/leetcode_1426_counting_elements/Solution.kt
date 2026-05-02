package leetcode.leetcode_1426_counting_elements

/**
 * leetcode - https://leetcode.com/problems/counting-elements/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map]
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies -
 */
private fun countElements(arr: IntArray): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    for (num in arr) {
        counter[num] = (counter[num] ?: 0) + 1
    }
    for ((num, _) in counter) {
        result += (counter[num - 1] ?: 0)
    }
    return result
}

private fun main() {

}
