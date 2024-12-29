package data_structures_and_algorithms.string

import kotlin.math.floor

fun isStringPalindrome(str: String): Boolean {
    for (i in 0..<floor((str.length / 2).toDouble()).toInt()) {
        if (str[i] != str[str.length - i - 1]) {
            return false
        }
    }
    return true
}
