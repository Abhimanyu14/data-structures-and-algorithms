package codility.lesson17_dynamic_programming

import kotlin.math.abs

private fun solution(A: IntArray): Int {
    if (A.isEmpty()) {
        return 0
    }
    val data = A.map { abs((it)) }.sorted()
    var result = data.last()
    var index = data.lastIndex - 1
    while (index >= 0) {
        if (result < 0) {
            result += data[index]
        } else {
            result -= data[index]
        }
        index--
    }
    return abs(result)
}
