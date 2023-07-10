package leetcode.leet_300_to_399.leet_392_is_subsequence

fun memoryEfficientIsSubsequence(s: String, t: String): Boolean {
    var i = 0
    t.forEach {
        if (i == s.length) {
            return true
        }
        if (it == s[i]) {
            i++
        }
    }
    if (i == s.length) {
        return true
    }
    return false
}

fun isSubsequence(s: String, t: String): Boolean {
    var i = 0
    var j = 0
    while (j < t.length && i < s.length) {
        if (t[j] == s[i]) {
            i++
        }
        j++
    }
    if (i == s.length) {
        return true
    }
    return false
}

private fun main() {
    val inputS1 = "abc"
    val inputT1 = "ahbgdc"
    val inputS2 = "axc"
    val inputT2 = "ahbgdc"
    println(isSubsequence(inputS1, inputT1))
    println(isSubsequence(inputS2, inputT2))
}
