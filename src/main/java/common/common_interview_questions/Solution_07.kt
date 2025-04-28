package common.common_interview_questions

/**
 * Char counter
 *
 * Using count { }
 */
private fun countGivenChar(str: String, char: Char): Int {
    return str.count { it == char }
}

private fun main() {
    println(countGivenChar("test", 't'))
}
