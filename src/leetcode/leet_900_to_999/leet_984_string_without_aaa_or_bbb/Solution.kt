package leetcode.leet_900_to_999.leet_984_string_without_aaa_or_bbb

/**
 * leetcode - https://leetcode.com/problems/string-without-aaa-or-bbb/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Stats
 *
 */
fun recursiveSolution(a: Int, b: Int, res: String): String? {
    println("$a $b $res")
    if (a < 0 || b < 0 || res.length >= 3 && (res.substring(res.length - 3) == "aaa" || res.substring(res.length - 3) == "bbb")) {
        return null
    }
    if (a == 0 && b == 0) {
        return res
    }
    return recursiveSolution(a - 1, b, res + "a") ?: recursiveSolution(a, b - 1, res + "b")
}


fun recursiveSolutionDriver(a: Int, b: Int): String {
    return recursiveSolution(a, b, "") ?: "$a $b not possible"
}

fun strWithout3a3b(a: Int, b: Int): String {
    var result = ""
    val highOccurrence: Char
    val lowOccurrence: Char
    var highOccurrenceCount: Int
    var lowOccurrenceCount: Int
    if (a >= b) {
        highOccurrence = 'a'
        lowOccurrence = 'b'
        highOccurrenceCount = a
        lowOccurrenceCount = b
    } else {
        highOccurrence = 'b'
        lowOccurrence = 'a'
        highOccurrenceCount = b
        lowOccurrenceCount = a
    }
    val diff = if (highOccurrenceCount <= lowOccurrenceCount * 2) {
        highOccurrenceCount - lowOccurrenceCount
    } else {
        lowOccurrenceCount
    }
    result += "$highOccurrence$highOccurrence$lowOccurrence".repeat(diff)
    highOccurrenceCount -= diff * 2
    lowOccurrenceCount -= diff
    result += "$highOccurrence$lowOccurrence".repeat(lowOccurrenceCount)
    highOccurrenceCount -= lowOccurrenceCount
    lowOccurrenceCount -= lowOccurrenceCount
    result += highOccurrence.toString().repeat(highOccurrenceCount)
    return result
}

private fun main() {
    println(strWithout3a3b(4, 1))
}
