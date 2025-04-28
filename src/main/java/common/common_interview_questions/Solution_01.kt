package common.common_interview_questions

/**
 * Reverse string
 *
 * Using string builder
 *
 * N - String length
 * Time - O(N)
 * Space - O(N)
 */
private fun reverseString(str: String): String {
    val stringBuilder = StringBuilder()
    for (i in str.indices.reversed()) {
        stringBuilder.append(str[i])
    }
    return stringBuilder.toString()
}

private fun main() {
    println(reverseString("Test"))
    println(reverseString("Test123"))
    println(reverseString("Random123"))
}
