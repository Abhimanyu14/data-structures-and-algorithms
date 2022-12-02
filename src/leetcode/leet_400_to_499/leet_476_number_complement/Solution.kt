package leetcode.leet_400_to_499.leet_476_number_complement

import kotlin.math.pow

/**
 * Using loop - memory efficient
 *
 * Stats
 * Runtime: 145 ms, faster than 87.50%
 * Memory Usage: 33 MB, less than 93.75%
 */
private fun findComplementBruteForce(num: Int): Int {
    val list = mutableListOf<Int>()
    var temp = num
    while (temp > 0) {
        list.add(temp % 2)
        temp /= 2
    }
    var result = 0
    var x: Int
    for (i in list.indices) {
        x = if (list[i] == 1) {
            0
        } else {
            1
        }
        result += (x * 2.0.pow(i)).toInt()
    }
    return result
}

/**
 * Using loop - memory efficient
 *
 * Stats
 * Runtime: 145 ms, faster than 87.50%
 * Memory Usage: 33 MB, less than 93.75%
 */
private fun findComplement(num: Int): Int {
    val list = mutableListOf<Int>()
    var temp = num
    while (temp > 0) {
        list.add(temp % 2)
        temp /= 2
    }
    var result = 0
    var x: Int
    for (i in list.indices) {
        x = if (list[i] == 1) {
            0
        } else {
            1
        }
        result += (x * 2.0.pow(i)).toInt()
    }
    return result
}

private fun main() {

}
