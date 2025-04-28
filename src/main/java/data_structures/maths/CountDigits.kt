package data_structures.maths

import kotlin.math.log10

private fun countDigits(n: Int): Int {
    return log10(n.toDouble()).toInt() + 1
}

private fun main() {
    println(countDigits(100))
    println(countDigits(1234))
    println(countDigits(1234567890))
}
