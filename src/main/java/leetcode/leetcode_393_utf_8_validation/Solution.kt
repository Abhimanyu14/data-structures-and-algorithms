package leetcode.leetcode_393_utf_8_validation

/**
 * leetcode - https://leetcode.com/problems/utf-8-validation/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - NA
 * Algorithm - Bit manipulation
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun validUtf8(data: IntArray): Boolean {
    var i = 0
    while (i <= `data`.lastIndex) {
        if (`data`[i] and 128 == 0) {
            i++
            continue
        }
        if (`data`[i] and 224 == 192) {
            if (i >= `data`.lastIndex || `data`[i + 1] and 192 != 128) {
                return false
            } else {
                i += 2
                continue
            }
        }
        if (`data`[i] and 240 == 224) {
            if (i >= `data`.lastIndex - 1 || `data`[i + 1] and 192 != 128 || `data`[i + 2] and 192 != 128) {
                return false
            } else {
                i += 3
                continue
            }
        }
        if (`data`[i] and 248 == 240) {
            if (i >= `data`.lastIndex - 2 || `data`[i + 1] and 192 != 128 || `data`[i + 1] and 192 != 128  || `data`[i + 2] and 192 != 128) {
                return false
            } else {
                i += 4
                continue
            }
        }
        return false
    }
    return true
}

private fun main() {

}
