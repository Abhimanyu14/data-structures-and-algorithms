package algorithms.memoization

/**
 * Question - https://youtu.be/oBt53YbR9Kk
 * Check if given string can be obtained from the set of words provided and they can be repeated
 * Result: Return a boolean denoting possible or not
 */
fun canConstruct(words: List<String>, target: String, memo: HashMap<String, Boolean>): Boolean {
    if (target == "") {
        return true
    }
    memo[target]?.let {
        return it
    }
    for (i in words.indices) {
        if (target.startsWith(words[i]) && canConstruct(words, target.removePrefix(words[i]), memo)) {
            memo[target] = true
            return true
        }
    }
    memo[target] = false
    return false
}

fun main() {
    val input1 = listOf("ab", "abc", "cd", "def", "abcd")
    val input2 = listOf("bo", "rd", "ate", "t", "ska", "sk", "boar")
    println(canConstruct(input1, "abcdef", hashMapOf()))
    println(canConstruct(input2, "skateboard", hashMapOf()))
}
