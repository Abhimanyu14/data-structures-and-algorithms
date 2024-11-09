package leetcode.leetcode_2325_decode_the_message

/**
 * leetcode - https://leetcode.com/problems/decode-the-message/description/
 *
 * Using StringBuilder, map & iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 9 ms, faster than 50.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun decodeMessage(key: String, message: String): String {
    val result = StringBuilder()
    val coding = mutableMapOf<Char, Char>()
    var index = 0
    key.forEach {
        if (it != ' ' && !coding.contains(it)) {
            coding[it] = 'a' + index
            index++
        }
    }
    message.forEach {
        if (it == ' ') {
            result.append(' ')
        } else {
            result.append(coding[it])
        }
    }
    return result.toString()
}

private fun main() {

}
