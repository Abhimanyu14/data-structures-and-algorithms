package leetcode.leet_984_string_without_aaa_or_bbb

fun solution(a: Int, b: Int, res: String): String? {
    println("$a $b $res")
    if (a < 0 || b < 0 || res.length >= 3 && (res.substring(res.length - 3) == "aaa" || res.substring(res.length - 3) == "bbb")) {
        return null
    }
    if (a == 0 && b == 0) {
        return res
    }
    return solution(a - 1, b, res + "a") ?: solution(a, b - 1, res + "b")
}

fun strWithout3a3b(a: Int, b: Int): String {
    return solution(a, b, "") ?: "$a $b not possible"
}

fun main() {
    println(strWithout3a3b(1, 3))
}
