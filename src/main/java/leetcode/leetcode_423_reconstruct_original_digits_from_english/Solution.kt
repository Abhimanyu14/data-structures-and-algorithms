package leetcode.leetcode_423_reconstruct_original_digits_from_english

/**
 * leetcode - https://leetcode.com/problems/reconstruct-original-digits-from-english/
 *
 * Data Structure - Array and Map
 * Algorithm - NA
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 6 ms, faster than 75.00%
 * Memory Usage: 38.7 MB, less than 40.00%
 *
 * Time -
 * Space -
 */
private fun originalDigits(s: String): String {
    val result = StringBuilder()
    val charCounter = IntArray(26)
    s.forEach {
        charCounter[it - 'a']++
    }
    val digitCounter = IntArray(10)

    digitCounter[0] = charCounter['z' - 'a']
    charCounter['z' - 'a'] -= digitCounter[0]
    charCounter['e' - 'a'] -= digitCounter[0]
    charCounter['r' - 'a'] -= digitCounter[0]
    charCounter['o' - 'a'] -= digitCounter[0]

    digitCounter[2] = charCounter['w' - 'a']
    charCounter['t' - 'a'] -= digitCounter[2]
    charCounter['w' - 'a'] -= digitCounter[2]
    charCounter['o' - 'a'] -= digitCounter[2]

    digitCounter[4] = charCounter['u' - 'a']
    charCounter['f' - 'a'] -= digitCounter[4]
    charCounter['o' - 'a'] -= digitCounter[4]
    charCounter['u' - 'a'] -= digitCounter[4]
    charCounter['r' - 'a'] -= digitCounter[4]

    digitCounter[6] = charCounter['x' - 'a']
    charCounter['s' - 'a'] -= digitCounter[6]
    charCounter['i' - 'a'] -= digitCounter[6]
    charCounter['x' - 'a'] -= digitCounter[6]

    digitCounter[8] = charCounter['g' - 'a']
    charCounter['e' - 'a'] -= digitCounter[8]
    charCounter['i' - 'a'] -= digitCounter[8]
    charCounter['g' - 'a'] -= digitCounter[8]
    charCounter['h' - 'a'] -= digitCounter[8]
    charCounter['t' - 'a'] -= digitCounter[8]

    digitCounter[1] = charCounter['o' - 'a']
    charCounter['o' - 'a'] -= digitCounter[1]
    charCounter['n' - 'a'] -= digitCounter[1]
    charCounter['e' - 'a'] -= digitCounter[1]

    digitCounter[5] = charCounter['f' - 'a']
    charCounter['f' - 'a'] -= digitCounter[5]
    charCounter['i' - 'a'] -= digitCounter[5]
    charCounter['v' - 'a'] -= digitCounter[5]
    charCounter['e' - 'a'] -= digitCounter[5]

    digitCounter[7] = charCounter['v' - 'a']
    charCounter['s' - 'a'] -= digitCounter[7]
    charCounter['e' - 'a'] -= digitCounter[7]
    charCounter['v' - 'a'] -= digitCounter[7]
    charCounter['e' - 'a'] -= digitCounter[7]
    charCounter['n' - 'a'] -= digitCounter[7]

    digitCounter[9] = charCounter['i' - 'a']
    charCounter['n' - 'a'] -= digitCounter[9]
    charCounter['i' - 'a'] -= digitCounter[9]
    charCounter['n' - 'a'] -= digitCounter[9]
    charCounter['e' - 'a'] -= digitCounter[9]

    digitCounter[3] = charCounter['t' - 'a']
    charCounter['t' - 'a'] -= digitCounter[3]
    charCounter['h' - 'a'] -= digitCounter[3]
    charCounter['r' - 'a'] -= digitCounter[3]
    charCounter['e' - 'a'] -= digitCounter[3]
    charCounter['e' - 'a'] -= digitCounter[3]

    repeat(10) { digit ->
        repeat(digitCounter[digit]) {
            result.append('0' + digit)
        }
    }
    return result.toString()
}

private fun main() {

}
