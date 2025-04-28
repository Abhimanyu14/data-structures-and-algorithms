package common.common_interview_questions

/**
 * Non repeated first char
 *
 * Using counter map
 */
private fun firstNonRepeatingChar(str: String): Char {
    val counter = mutableMapOf<Char, Int>()
    val chars = mutableListOf<Char>()
    str.forEach {
        if (!counter.contains(it)) {
            chars.add(it)
        }
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    return chars.first {
        counter.getOrDefault(it, 0) == 1
    }
}

private fun main() {
    println(firstNonRepeatingChar("asfbkabfjkdasbkfasd"))
}
