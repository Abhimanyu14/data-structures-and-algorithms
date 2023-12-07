package data_structures_and_algorithms.common

/**
 * Is Rotated string
 * Leetcode 796
 * https://leetcode.com/problems/rotate-string/
 *
 * Using count { }
 */
private fun isRotatedString(str1: String, str2: String): Boolean {
    return "$str1$str1".contains(str2)
}

private fun main() {
    println(isRotatedString("test", "ttes"))
}
