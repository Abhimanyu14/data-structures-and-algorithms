package leetcode.leet_0_to_99.leet_66_plus_one

/**
 * Stats
 * Runtime: 192 ms, faster than 29.71%
 * Memory Usage: 36.6 MB, less than 19.17%
 */
fun addWithCarry(arr: IntArray, position: Int): Int {
    if (position == arr.size) {
        return 1
    }
    val res = arr[position] + addWithCarry(arr, position + 1)
    arr[position] = res % 10
    return res / 10
}

fun plusOne(digits: IntArray): IntArray {
    val carry = addWithCarry(digits, 0)
    if (carry > 0) {
        val newArray = digits.asList().toMutableList()
        newArray.add(0, carry)
        return newArray.toIntArray()
    }
    return digits
}

fun main() {
    val input1 = intArrayOf(1, 2, 3)
    val input2 = intArrayOf(4, 3, 2, 1)
    val input3 = intArrayOf(0)
    println(plusOne(input1).joinToString(" "))
    println(plusOne(input2).joinToString(" "))
    println(plusOne(input3).joinToString(" "))
}
