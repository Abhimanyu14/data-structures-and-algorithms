package leetcode.leet_1000_to_1099.leet_1071_greatest_common_divisor_of_strings

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * Using GCD
 *
 * Stats
 * Runtime: 152 ms, faster than 77.94%
 * Memory Usage: 36.7 MB, less than 75.37%
 */
private fun gcdOfStrings(str1: String, str2: String): String {
    if (str1 + str2 != str2 + str1) {
        return ""
    }
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else {
            gcd(b, a % b)
        }
    }
    return str1.substring(0, gcd(str1.length, str2.length))
}

/**
 * leetcode - https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * Using GCD
 *
 * Stats
 * Runtime: 205 ms, faster than 17.65%
 * Memory Usage: 37.2 MB, less than 44.49%
 */
private fun gcdOfStringsUsingIteration(str1: String, str2: String): String {
    fun getCommonDivisors(x: Int, y: Int): List<Int> {
        val larger = max(x, y)
        val smaller = min(x, y)
        val result = mutableListOf<Int>()
        var current = smaller
        var factor = 1
        while (current >= 1) {
            if (larger % current == 0) {
                result.add(current)
            }
            factor++
            current = smaller / factor
            while (current > 0 && smaller % factor != 0) {
                factor++
                current = smaller / factor
            }
        }
        return result
    }
    getCommonDivisors(str1.length, str2.length).forEach {
        val times1 = str1.length / it
        val times2 = str2.length / it
        val subString = str1.substring(0, it)
        if (subString.repeat(times1) == str1 && subString.repeat(times2) == str2) {
            return subString
        }
    }
    return ""
}

private fun main() {

}
