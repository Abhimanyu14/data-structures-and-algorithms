package leetcode.leet_917_reverse_only_letters

/**
 * Using loop
 *
 * Stats
 * Runtime: 283 ms, faster than 30.77%
 * Memory Usage: 37.9 MB, less than 7.69%
 */
private fun reverseOnlyLetters(s: String): String {
    val result = s.toCharArray()
    var start = 0
    var end = s.lastIndex
    while (start < end) {
        if (s[start].isLetter() && s[end].isLetter()) {
            result[start] = result[end].also {
                result[end] = result[start]
            }
            start++
            end--
        } else {
            if (!s[start].isLetter()) {
                start++
            }
            if (!s[end].isLetter()) {
                end--
            }
        }
    }
    return result.joinToString("")
}

private fun main() {
    println(reverseOnlyLetters("ab-cd") == "dc-ba")
    println(reverseOnlyLetters("a-bC-dEf-ghIj") == "j-Ih-gfE-dCba")
    println(reverseOnlyLetters("Test1ng-Leet=code-Q!") == "Qedo1ct-eeLg=ntse-T!")
}
