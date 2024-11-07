package leetcode

/**
 * Set<Char> from a String
 */
val chars = "Temp".toSet()

/**
 * To clone an array
 */
val array1 = intArrayOf(1, 2, 3)
val cloneArray = array1.clone()

/**
 * To count number of 1 bit in binary representation.
 */
const val value: Int = 123
val bitsCount: Int = value.countOneBits()

/**
 * To count leading zero bits
 */
val leadingZeroBitCount: Int = value.countLeadingZeroBits()

/**
 * To get number of binary digits of a number
 */
fun numberOfBinaryDigits(n: Int): Int {
    if (n == 0) return 1  // Special case: 0 has 1 binary digit (just "0")
    return 32 - n.countLeadingZeroBits()
}

/**
 * To get if ith bit of a number is set
 */
fun checkIthBitIsSet(n: Int, i: Int): Boolean {
    return (n and (1 shl i)) != 0
}

/**
 * To insert at start of string builder
 */
fun appendAtStart() {
    val stringBuilder = StringBuilder()
    stringBuilder.insert(0, 5)
}
