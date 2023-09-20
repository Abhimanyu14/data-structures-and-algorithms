package data_structures_and_algorithms.memoization

/**
 * Question - https://youtu.be/oBt53YbR9Kk
 * Check if given string can be obtained from the set of words provided and they can be repeated
 * Result: Return a count of number of possible ways
 */
fun countConstruct(words: List<String>, target: String, memo: HashMap<String, Int>): Int {
    if (target == "") {
        return 1
    }
    memo[target]?.let {
        return it
    }
    memo[target] = 0
    for (i in words.indices) {
        if (target.startsWith(words[i])) {
            countConstruct(words, target.removePrefix(words[i]), memo).let {
                memo[target] = memo[target]?.plus(it) ?: 0
            }
        }
    }
    return memo[target] ?: 0
}

fun main() {
    val input1 = listOf("ab", "abc", "cd", "def", "abcd") // 1
    val input2 = listOf("bo", "rd", "ate", "t", "ska", "sk", "boar") // 0
    val input3 = listOf("purp", "p", "ur", "le", "purpl") //
    println(countConstruct(input1, "abcdef", hashMapOf()))
    println(countConstruct(input2, "skateboard", hashMapOf()))
    println(countConstruct(input3, "purple", hashMapOf()))
}
