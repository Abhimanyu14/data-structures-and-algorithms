package leetcode.leetcode_670_maximum_swap

import kotlin.math.log2

/**
 * leetcode - https://leetcode.com/problems/maximum-swap/
 *
 * TODO(Abhi) - To revisit
 *
 * Using greedy
 *
 * Stats
 * Runtime: 149 ms, faster than 41.49%
 * Memory Usage: 33.3 MB, less than 79.79%
 */
private fun maximumSwap(num: Int): Int {
    val list = Array(log2 (num.toDouble()).toInt() + 1) { Pair(0,0) }
    val numArray = num.toString().toCharArray()
    var index = numArray.lastIndex
    var largestSoFar = numArray[index].digitToInt()
    var largestIndex = index
    list[index] = Pair(largestSoFar, largestIndex)
    index--
    while (index >= 0) {
        if (largestSoFar <= numArray[index].digitToInt()) {
            largestSoFar = numArray[index].digitToInt()
            largestIndex = index
        }
        list[index] = Pair(largestSoFar, largestIndex)
        index--
    }
    for (i in 0..<numArray.lastIndex) {
        if (list[i].second != i) {
            numArray[i] = numArray[list[i].second].also {
                numArray[list[i].second] = numArray[i]
            }
        }
    }
    return numArray.joinToString().toInt()
}

private fun maximumSwap1(num: Int): Int {
    val chars = num.toString().toCharArray()
    val last = IntArray(10)
    for (i in chars.indices) {
        last[chars[i] - '0'] = i
    }
    for (i in chars.indices) {
        for (digit in 9 downTo chars[i] - '0' + 1) {
            if (last[digit] > i) {
                chars[i] = chars[last[digit]].also {
                    chars[last[digit]] = chars[i]
                }
                return String(chars).toInt()
            }
        }
    }
    return num
}

private fun main() {

}
