package codility.lesson15_caterpillar_method

import kotlin.math.abs

private fun solution(A: IntArray): Int {
    val set = mutableSetOf<Int>()
    A.forEach {
        set.add(abs(it))
    }
    return set.size
}
