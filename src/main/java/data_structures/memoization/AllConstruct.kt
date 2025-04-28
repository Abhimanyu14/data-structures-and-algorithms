package data_structures.memoization

/**
 * Question - https://youtu.be/oBt53YbR9Kk
 * Check if given string can be obtained from the set of words provided and they can be repeated
 * Result: array of array of all combinations
 */
fun allConstruct(words: List<String>, target: String, memo: HashMap<String, List<List<String>>?>): List<List<String>>? {
    if (target == "") {
        return listOf(emptyList())
    }
    memo[target]?.let {
        return it
    }
    val tempList = mutableListOf<List<String>>()
    words.forEach { word ->
        if (target.startsWith(word)) {
            val result = allConstruct(words, target.removePrefix(word), memo)
            result?.let { list ->
                tempList.addAll(list.map { innerList ->
                    val temp = innerList.toMutableList()
                    temp.add(0, word)
                    temp.toList()
                })
            }
        }
    }
    memo[target] = tempList.ifEmpty { null }
    return memo[target]
}

private fun main() {
    val input1 = listOf("ab", "abc", "cd", "def", "abcd") // 1
    val input2 = listOf("bo", "rd", "ate", "t", "ska", "sk", "boar") // 0
    val input3 = listOf("purp", "p", "ur", "le", "purpl") //
    val input4 = listOf("ab", "abc", "cd", "def", "abcd", "ef", "c") //
    println(allConstruct(input1, "abcdef", hashMapOf()))
    println(allConstruct(input2, "skateboard", hashMapOf()))
    println(allConstruct(input3, "purple", hashMapOf()))
    println(allConstruct(input4, "abcdef", hashMapOf()))
}
