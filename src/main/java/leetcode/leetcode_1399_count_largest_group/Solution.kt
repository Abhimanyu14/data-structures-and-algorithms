package leetcode.leetcode_1399_count_largest_group

/**
 * leetcode - https://leetcode.com/problems/count-largest-group/description/?envType=daily-question&envId=2025-04-23
 *
 * Data Structure - [Map], [List]
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun countLargestGroup(n: Int): Int {
    var result = 0
    var maxSize = 0
    val map = mutableMapOf<Int, MutableList<Int>>()
    fun sumOfDigits(x: Int): Int {
        var sum = 0
        var temp = x
        while (temp != 0) {
            sum += temp % 10
            temp /= 10
        }
        return sum
    }
    for (i in 1..n) {
        val sum = sumOfDigits(i)
        map.computeIfAbsent(sum) {
            mutableListOf()
        }.add(i)
        if (maxSize == (map[sum]?.size ?: 0)) {
            result++
        } else if (maxSize < (map[sum]?.size ?: 0)) {
            maxSize = map[sum]?.size ?: 0
            result = 1
        }
    }
    return result
}

private fun main() {

}
