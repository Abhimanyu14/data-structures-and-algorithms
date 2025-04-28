package common.common_interview_questions

/**
 * Character counter
 *
 * Using map
 */
private fun charCounter(str: String): Map<Char, Int> {
    val map = mutableMapOf<Char, Int>()
    str.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    return map
}

private fun main() {
    val result = charCounter("ababacadafersa")
    result.forEach {(key, value) ->
        println("$key: $value")
    }
}
