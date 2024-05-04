package codility.lesson1_iterations

import kotlin.math.max

private fun solution(N: Int): Int {
    var temp = N
    var result = 0
    var current = 0
    var flag = false
    while (temp != 0) {
        if (flag) {
            if (temp % 2 == 0) {
                current++
            } else {
                result = max(result, current)
                current = 0
            }
        } else {
            if (temp % 2 == 1) {
                flag = true
            }
        }
        temp /= 2
    }
    return result
}
