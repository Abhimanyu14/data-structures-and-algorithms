package leetcode.leetcode_2103_rings_and_rods

/**
 * leetcode - https://leetcode.com/problems/rings-and-rods/
 *
 * Using bitwise OR
 *
 * Stats
 * Runtime: 134 ms, faster than 100.00%
 * Memory Usage: 33.8 MB, less than 100.00%
 */
fun countPoints(rings: String): Int {
    var i = 0
    val rods = Array(10) { 0 }
    // Leetcode does not support Char.digitToInt() - use toString().toInt() instead
    while (i < rings.length) {
        when (rings[i]) {
            'R' -> {
                rods[rings[i + 1].toString().toInt()] = rods[rings[i + 1].toString().toInt()] or 1
            }

            'G' -> {
                rods[rings[i + 1].toString().toInt()] = rods[rings[i + 1].toString().toInt()] or 10
            }

            'B' -> {
                rods[rings[i + 1].toString().toInt()] = rods[rings[i + 1].toString().toInt()] or 100
            }
        }
        i += 2
    }
    return rods.count { it == 111 }
}

private fun main() {
    println(countPoints("B0B6G0R6R0R6G9"))
    println(countPoints("B0R0G0R9R0B0G0"))
    println(countPoints("G4"))
}
