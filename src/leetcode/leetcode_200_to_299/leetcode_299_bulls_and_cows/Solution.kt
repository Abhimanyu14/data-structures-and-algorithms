package leetcode.leetcode_200_to_299.leetcode_299_bulls_and_cows

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/bulls-and-cows/
 *
 * Using single maps
 *
 * Stats
 * Runtime: 375 ms, faster than 19.73%
 * Memory Usage: 37.9 MB, less than 17.01%
 */
private fun getHint(secret: String, guess: String): String {
    val map = mutableMapOf<Char, Int>()
    var bulls = 0
    var cows = 0
    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            bulls++
        } else {
            if (map.getOrDefault(secret[i], 0) > 0) {
                cows++
            }
            map[secret[i]] = 1 - map.getOrDefault(secret[i], 0)
            if (map.getOrDefault(guess[i], 0) < 0) {
                cows++
            }
            map[guess[i]] = 1 + map.getOrDefault(guess[i], 0)
        }
    }
    return "${bulls}A${cows}B"
}

/**
 * leetcode - https://leetcode.com/problems/bulls-and-cows/
 *
 * Using two maps
 *
 * Stats
 * Runtime: 312 ms, faster than 52.38%
 * Memory Usage: 37 MB, less than 30.61%
 */
private fun getHintUsingTwoMaps(secret: String, guess: String): String {
    val secretMap = mutableMapOf<Char, Int>()
    val guessMap = mutableMapOf<Char, Int>()
    var bull = 0
    var cow = 0
    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            bull++
        } else {
            secretMap[secret[i]] = 1 + (secretMap[secret[i]] ?: 0)
            guessMap[guess[i]] = 1 + (guessMap[guess[i]] ?: 0)
        }
    }
    for (key in secretMap.keys) {
        cow += min(secretMap[key] ?: 0, guessMap[key] ?: 0)
    }
    return "${bull}A${cow}B"
}

private fun main() {

}
