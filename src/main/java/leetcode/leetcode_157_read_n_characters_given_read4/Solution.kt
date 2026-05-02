package leetcode.leetcode_157_read_n_characters_given_read4

/**
 * leetcode - https://leetcode.com/problems/read-n-characters-given-read4/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Apple, Google, Meta
 */
private abstract class Reader4() {
    fun read4(buf4: CharArray): Int {
        return 0
    }

    abstract fun read(buf: CharArray, n: Int): Int
}

private class Solution : Reader4() {
    /**
     * @param buf Destination buffer
     * @param n Number of characters to read
     * @return The number of actual characters read
     */
    override fun read(buf: CharArray, n: Int): Int {
        var result = 0
        val buffer = CharArray(4)
        var currentSize = read4(buffer)
        var index = 0
        while (currentSize != 0) {
            for (i in 0..<currentSize) {
                buf[(index * 4) + i] = buffer[i]
                result++
                if (result == n) {
                    break
                }
            }
            if (result == n) {
                break
            }
            currentSize = read4(buffer)
            index++
        }
        return result
    }
}

private fun main() {

}
