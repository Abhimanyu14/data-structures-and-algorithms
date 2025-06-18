package leetcode.leetcode_670_maximum_swap

/**
 * leetcode - https://leetcode.com/problems/maximum-swap/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Greedy
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun maximumSwap(num: Int): Int {
    val digits = num.toString().toCharArray()
    var largestDigitIndex = digits.lastIndex
    var canSwap = false
    var swapFrom = 0
    var swapTo = 0
    for (i in (digits.lastIndex - 1) downTo 0) {
        if (digits[largestDigitIndex].digitToInt() < digits[i].digitToInt()) {
            largestDigitIndex = i
        } else if (digits[largestDigitIndex].digitToInt() > digits[i].digitToInt()) {
            swapFrom = largestDigitIndex
            swapTo = i
            canSwap = true
        }
    }
    if (canSwap) {
        digits[swapFrom] = digits[swapTo].also {
            digits[swapTo] = digits[swapFrom]
        }
    }
    return digits.joinToString("").toInt()
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
