package common.common_interview_questions

/**
 * Reverse number
 *
 * Using iteration
 */
private fun reverseNumber(n: Int): Int {
    var result = 0
    var temp = n
    while (temp != 0) {
        result = result * 10 + (temp % 10)
        temp /= 10
    }
    return result
}

private fun main() {
    println(reverseNumber(75))
}
