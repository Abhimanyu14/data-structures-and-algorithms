package data_structures.string

import kotlin.math.floor

fun isStringPalindrome(str: String): Boolean {
    for (i in 0 until floor((str.length / 2).toDouble()).toInt()) {
        if (str[i] != str[str.length - i - 1]) {
            return false
        }
    }
    return true
}
