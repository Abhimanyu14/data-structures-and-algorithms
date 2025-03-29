package hackerrank.practice.two_characters

/**
 * WIP
 */
fun alternate(s: String): Int {
    var tempStr = s
    var adjChar = getAdjacentChar(tempStr)
    while (adjChar != '0') {
        tempStr = tempStr.replace(adjChar.toString(), "")
        adjChar = getAdjacentChar(tempStr)
    }
    val chars = tempStr.toCharArray().distinct()
    if (chars.size == 2) {
        return tempStr.length
    } else {
        return alternate(tempStr)
    }
}

fun getAdjacentChar(s: String): Char {
    var prevChar = s[0]
    for (i in 1..s.lastIndex) {
        if (prevChar == s[i]) {
            return prevChar
        }
        prevChar = s[i]
    }
    return '0'
}

private fun main() {
    val result = alternate("abaacdabd")
    println(result)
}
