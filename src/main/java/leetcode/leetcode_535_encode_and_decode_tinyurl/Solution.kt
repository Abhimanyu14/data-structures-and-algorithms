package leetcode.leetcode_535_encode_and_decode_tinyurl

/**
 * leetcode - https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 * Using map and counter
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 179 ms, faster than 88.89%
 * Memory Usage: 37.3 MB, less than 53.57%
 *
 *
 * Time -
 * Space -
 */
private class Codec() {
    private var counter: Int = 0
    private val map = mutableMapOf<String, String>()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        map["$counter"] = longUrl
        counter++
        return "${counter - 1}"
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return map.getOrDefault(shortUrl, "")
    }
}

private fun main() {

}
