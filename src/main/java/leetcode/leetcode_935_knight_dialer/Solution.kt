package leetcode.leetcode_935_knight_dialer

/**
 * leetcode - https://leetcode.com/problems/knight-dialer/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Efficient Iteration On States
 *
 * Stats
 * Runtime: 138 ms, faster than 100.00%
 * Memory Usage: 33.5 MB, less than 83.33%
 */
private fun knightDialer(n: Int): Int {
    if (n == 1) {
        return 10
    }
    var a = 4
    var b = 2
    var c = 2
    var d = 1
    val mod = 1e9.toInt() + 7
    for (i in 0..<n - 1) {
        val tempA = a
        val tempB = b
        val tempC = c
        val tempD = d
        a = (2 * tempB % mod + 2 * tempC % mod) % mod
        b = tempA
        c = (tempA + 2 * tempD % mod) % mod
        d = tempC
    }
    var result = (a + b) % mod
    result = (result + c) % mod
    return (result + d) % mod
}

private fun main() {

}
