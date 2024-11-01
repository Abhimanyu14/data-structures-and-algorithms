package leetcode.leetcode_2300_to_2399.leetcode_2384_largest_palindromic_number

/**
 * leetcode - https://leetcode.com/problems/largest-palindromic-number/description/
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 211 ms, faster than 100.00%
 * Memory Usage: 38.9 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun largestPalindromic(num: String): String {
    val result = StringBuilder()
    val counter = IntArray(10)
    num.forEach {
        counter[it - '0']++
    }
    var middleChar = -1

    fun handleChar(i: Int) {
        if (counter[i] > 1) {
            repeat(counter[i] / 2) {
                result.append(i)
            }
            if (counter[i] % 2 == 0) {
                counter[i] -= counter[i] / 2
            } else {
                if (middleChar == -1) {
                    middleChar = i
                }
                counter[i] -= ((counter[i] / 2) + 1)
            }
        } else if (counter[i] == 1) {
            if (middleChar == -1) {
                middleChar = i
            }
            counter[i] = 0
        }
    }
    for (i in 9 downTo 1) {
        handleChar(i)
    }
    if (result.isEmpty()) {
        counter[0] = 0
    } else {
        handleChar(0)
    }

    if (middleChar != -1) {
        result.append(middleChar)
    }

    for (i in 0..9) {
        if (counter[i] > 0) {
            repeat(counter[i]) {
                result.append(i)
            }
        }
    }
    return result.toString().ifEmpty {
        "0"
    }
}


private fun main() {

}
