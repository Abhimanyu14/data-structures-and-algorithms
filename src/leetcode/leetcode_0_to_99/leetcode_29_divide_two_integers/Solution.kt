package leetcode.leetcode_0_to_99.leetcode_29_divide_two_integers

// TODO-Abhi: Revisit for other approaches

/**
 * leetcode - https://leetcode.com/problems/divide-two-integers/
 *
 * Using repeated subtraction
 *
 * Stats
 * Time Limit Exceeded
 */
fun divideUsingRepeatedSubtraction(dividend: Int, divisor: Int): Int {
    // Special case: overflow.
    var dividendCopy = dividend
    var divisorCopy = divisor
    if (dividendCopy == Int.MIN_VALUE && divisorCopy == -1) {
        return Int.MAX_VALUE
    }

    /* We need to convert both numbers to negatives
     * for the reasons explained above.
     * Also, we count the number of negatives signs. */
    var negatives = 2
    if (dividendCopy > 0) {
        negatives--
        dividendCopy = -dividendCopy
    }
    if (divisorCopy > 0) {
        negatives--
        divisorCopy = -divisorCopy
    }

    /* Count how many times the divisor has to be added
     * to get the dividend. This is the quotient. */
    var quotient = 0
    while (dividendCopy - divisorCopy <= 0) {
        quotient--
        dividendCopy -= divisorCopy
    }

    /* If there was originally one negative sign, then
     * the quotient remains negative. Otherwise, switch
     * it to positive. */
    if (negatives != 1) {
        quotient = -quotient
    }
    return quotient
}

/**
 * leetcode - https://leetcode.com/problems/divide-two-integers/
 *
 * Using repeated exponential searches
 *
 * Stats
 * Runtime: 168 ms, faster than 87.34%
 * Memory Usage: 34 MB, less than 65.82%
 */
private var HALF_INT_MIN: Int = -1073741824

fun divide(dividend: Int, divisor: Int): Int {
    // Special case: overflow.
    if (dividend == Int.MIN_VALUE && divisor == -1) {
        return Int.MAX_VALUE
    }

    var dividendCopy = dividend
    var divisorCopy = divisor

    /* We need to convert both numbers to negatives.
     * Also, we count the number of negatives numbers. */
    var negatives = 2
    if (dividendCopy > 0) {
        negatives--
        dividendCopy = -dividendCopy
    }
    if (divisorCopy > 0) {
        negatives--
        divisorCopy = -divisorCopy
    }
    var quotient = 0
    /* Once the divisor is bigger than the current dividend,
     * we can't fit any more copies of the divisor into it. */

    while (divisorCopy >= dividendCopy) {
        /* We know it'll fit at least once as dividend >= divisor.
         * Note: We use a negative powerOfTwo as it's possible we might have
         * the case divide(INT_MIN, -1). */
        var powerOfTwo = -1
        var value = divisorCopy
        /* Check if double the current value is too big. If not, continue doubling.
         * If it is too big, stop doubling and continue with the next step */

        while (value >= HALF_INT_MIN && value + value >= dividendCopy) {
            value += value
            powerOfTwo += powerOfTwo
        }
        // We have been able to subtract divisor another powerOfTwo times.
        quotient += powerOfTwo
        // Remove value so far so that we can continue the process with remainder.
        dividendCopy -= value
    }

    /* If there was originally one negative sign, then
     * the quotient remains negative. Otherwise, switch
     * it to positive. */
    return if (negatives != 1) {
        -quotient
    } else {
        quotient
    }
}

private fun main() {

}
