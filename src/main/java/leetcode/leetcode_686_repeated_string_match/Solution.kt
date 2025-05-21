package leetcode.leetcode_686_repeated_string_match

import java.math.BigInteger

/**
 * leetcode - https://leetcode.com/problems/repeated-string-match/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Rabin Karp
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Microsoft
 */

private const val MOD = 1_000_000_007

fun repeatedStringMatch(a: String, b: String): Int {
    fun check(index: Int): Boolean {
        for (i in b.indices) {
            if (a[(i + index) % a.length] != b[i]) {
                return false
            }
        }
        return true
    }

    val q = b.lastIndex / a.lastIndex
    val p = 113

    val pInv = BigInteger.valueOf(p.toLong()).modInverse(BigInteger.valueOf(MOD.toLong())).toInt()

    var bHash: Long = 0
    var power: Long = 1
    for (i in b.indices) {
        bHash += power * b.codePointAt(i)
        bHash %= MOD.toLong()
        power = (power * p) % MOD
    }

    var aHash: Long = 0
    power = 1
    for (i in b.indices) {
        aHash += power * a.codePointAt(i % a.length)
        aHash %= MOD.toLong()
        power = (power * p) % MOD
    }

    if (aHash == bHash && check(0)) {
        return q
    }
    power = (power * pInv) % MOD

    for (i in b.length..<(q + 1) * a.length) {
        aHash -= a.codePointAt((i - b.length) % a.length).toLong()
        aHash *= pInv.toLong()
        aHash += power * a.codePointAt(i % a.length)
        aHash %= MOD.toLong()
        if (aHash == bHash && check(i - b.length + 1)) {
            return if (i < q * a.length) {
                q
            } else {
                q + 1
            }
        }
    }
    return -1
}

private fun main() {

}
