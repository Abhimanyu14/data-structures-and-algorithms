package leetcode.leet_0_to_99.leet_67_add_binary

/**
 * leetcode - https://leetcode.com/problems/add-binary/
 *
 * Using simulation
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 175 ms, faster than 59.57%
 * Memory Usage: 37.2 MB, less than 37.67%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun addBinary(a: String, b: String): String {
    val result = StringBuilder()
    var aPointer = a.lastIndex
    var bPointer = b.lastIndex
    var carry = 0
    while (aPointer >= 0 && bPointer >= 0) {
        when (a[aPointer].digitToInt() + b[bPointer].digitToInt() + carry) {
            0 -> {
                result.append('0')
                carry = 0
            }

            1 -> {
                result.append('1')
                carry = 0
            }

            2 -> {
                result.append('0')
                carry = 1
            }

            else -> {
                result.append('1')
                carry = 1
            }
        }
        aPointer--
        bPointer--
    }
    while (aPointer >= 0) {
        when (a[aPointer].digitToInt() + carry) {
            0 -> {
                result.append('0')
                carry = 0
            }

            1 -> {
                result.append('1')
                carry = 0
            }

            2 -> {
                result.append('0')
                carry = 1
            }
        }
        aPointer--
    }
    while (bPointer >= 0) {
        when (b[bPointer].digitToInt() + carry) {
            0 -> {
                result.append('0')
                carry = 0
            }

            1 -> {
                result.append('1')
                carry = 0
            }

            2 -> {
                result.append('0')
                carry = 1
            }
        }
        bPointer--
    }
    if (carry == 1) {
        result.append('1')
    }
    return result.reverse().toString()
}

private fun main() {

}
