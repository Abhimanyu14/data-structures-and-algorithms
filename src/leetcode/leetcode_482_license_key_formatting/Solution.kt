package leetcode.leetcode_482_license_key_formatting

/**
 * Using loop and pointer
 *
 * Stats
 * Runtime: 2464 ms, faster than 14.29%
 * Memory Usage: 710 MB, less than 8.57%
 */
private fun licenseKeyFormatting(s: String, k: Int): String {
    var result = ""
    var j = s.length - 1
    var dashCounter = 0
    while (j >= 0) {
        if (s[j] != '-') {
            if (dashCounter == k) {
                result = "-$result"
                dashCounter = 0
            }
            result = "${s[j].uppercaseChar()}${result}"
            dashCounter++
        }
        j--
    }
    return result
}

private fun main() {

}
