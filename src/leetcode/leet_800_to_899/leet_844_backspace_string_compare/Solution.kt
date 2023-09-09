package leetcode.leet_800_to_899.leet_844_backspace_string_compare

/**
 * leetcode - https://leetcode.com/problems/backspace-string-compare/
 *
 * Using loops
 *
 * Stats
 * Runtime: 169 ms, faster than 22.64%
 * Memory Usage: 34.9 MB, less than 32.08%
 */
private fun backspaceCompare(s: String, t: String): Boolean {
    var index1 = s.lastIndex
    var index2 = t.lastIndex
    var tempCount = 0

    while (index1 > -1 || index2 > -1) {
        tempCount = 0
        while (index1 > -1 && (s[index1] == '#' || tempCount > 0)) {
            if (s[index1] == '#') {
                tempCount++
            } else {
                tempCount--
            }
            index1--
        }
        tempCount = 0
        while (index2 > -1 && (t[index2] == '#' || tempCount > 0)) {
            if (t[index2] == '#') {
                tempCount++
            } else {
                tempCount--
            }
            index2--
        }
        if (index1 == -1 && index2 == -1) {
            return true
        } else if (index1 == -1 || index2 == -1) {
            return false
        }
        if (s[index1] != t[index2]) {
            return false
        } else {
            index1--
            index2--
        }
    }
    return index1 == -1 && index2 == -1
}

private fun main() {
    println(backspaceCompare("nzp#o#g", "b#nzp#o#g"))
}
