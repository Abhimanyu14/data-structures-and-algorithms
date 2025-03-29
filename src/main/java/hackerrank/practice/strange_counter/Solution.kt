package hackerrank.practice.strange_counter

import kotlin.math.pow

fun bruteForceStrangeCounter(t: Long): Long {
    var result = 4
    var i = 0
    var prevMax = 3
    while (i < t) {
        if (result == 1) {
            prevMax *= 2
            result = prevMax
        } else {
            result--
        }
        i++
    }
    return result.toLong()
}

fun strangeCounterUsingMath(t: Long): Long {
    var n = 0
    while (3 * (2.0.pow((n + 1).toDouble()) - 1) < t) {
        n++
    }
    return ((3 * (2.0.pow((n + 1).toDouble()) - 1)) - t + 1).toLong()
}


fun strangeCounter(t: Long): Long {
    return 12 * ((t + 2) / 3).takeHighestOneBit() - t - 2
}

private fun main() {
    for (i in 0..30) {
        val result = strangeCounter(i.toLong())
        println(result)
    }
}
