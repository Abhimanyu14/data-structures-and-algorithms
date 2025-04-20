package leetcode.leetcode_66_plus_one

/**
 * leetcode - https://leetcode.com/problems/plus-one/
 *
 * Data Structure - [List], [IntArray]
 * Algorithm - Iteration
 *
 * List methods - [MutableList.add], [MutableList.toIntArray]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 16 ms, faster than 23.44%
 * Memory Usage: 45.89 MB, less than 8.47%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun plusOne(digits: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var carry = 1
    for (i in digits.lastIndex downTo 0) {
        val sum = digits[i] + carry
        carry = sum / 10
        result.add(0, sum % 10)
    }
    if (carry != 0) {
        result.add(0, carry)
    }
    return result.toIntArray()
}

private fun addWithCarry(arr: IntArray, position: Int): Int {
    if (position == arr.size) {
        return 1
    }
    val res = arr[position] + addWithCarry(arr, position + 1)
    arr[position] = res % 10
    return res / 10
}

private fun plusOneUsingRecursion(digits: IntArray): IntArray {
    val carry = addWithCarry(digits, 0)
    if (carry > 0) {
        val newArray = digits.asList().toMutableList()
        newArray.add(0, carry)
        return newArray.toIntArray()
    }
    return digits
}

private fun main() {
    val input1 = intArrayOf(1, 2, 3)
    val input2 = intArrayOf(4, 3, 2, 1)
    val input3 = intArrayOf(0)
    println(plusOne(input1).joinToString(" "))
    println(plusOne(input2).joinToString(" "))
    println(plusOne(input3).joinToString(" "))
}
