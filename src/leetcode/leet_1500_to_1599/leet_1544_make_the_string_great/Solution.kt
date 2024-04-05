package leetcode.leet_1500_to_1599.leet_1544_make_the_string_great

import java.util.ArrayDeque

/**
 * leetcode - https://leetcode.com/problems/make-the-string-great/?envType=daily-question&envId=2024-04-05
 *
 * Using stack
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 227 ms, faster than 6.45%
 * Memory Usage: 42.8 MB, less than 6.45%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun makeGood(s: String): String {
    val map = mapOf(
        'a' to 'A',
        'b' to 'B',
        'c' to 'C',
        'd' to 'D',
        'e' to 'E',
        'f' to 'F',
        'g' to 'G',
        'h' to 'H',
        'i' to 'I',
        'j' to 'J',
        'k' to 'K',
        'l' to 'L',
        'm' to 'M',
        'n' to 'N',
        'o' to 'O',
        'p' to 'P',
        'q' to 'Q',
        'r' to 'R',
        's' to 'S',
        't' to 'T',
        'u' to 'U',
        'v' to 'V',
        'w' to 'W',
        'x' to 'X',
        'y' to 'Y',
        'z' to 'Z',
        'A' to 'a',
        'B' to 'b',
        'C' to 'c',
        'D' to 'd',
        'E' to 'e',
        'F' to 'f',
        'G' to 'g',
        'H' to 'h',
        'I' to 'i',
        'J' to 'j',
        'K' to 'k',
        'L' to 'l',
        'M' to 'm',
        'N' to 'n',
        'O' to 'o',
        'P' to 'p',
        'Q' to 'q',
        'R' to 'r',
        'S' to 's',
        'T' to 't',
        'U' to 'u',
        'V' to 'v',
        'W' to 'w',
        'X' to 'x',
        'Y' to 'y',
        'Z' to 'z',
    )
    val stack = ArrayDeque<Char>()
    s.forEach {
        if (stack.lastOrNull() == map[it]) {
            stack.removeLast()
        } else {
            stack.add(it)
        }
    }
    return stack.joinToString("")
}

private fun main() {

}
