package leetcode.leetcode_165_compare_version_numbers

/**
 * leetcode - https://leetcode.com/problems/compare-version-numbers/?envType=daily-question&envId=2024-05-03
 *
 * Using iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 175 ms, faster than 8.33%
 * Memory Usage: 33.5 MB, less than 100.00%
 *
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun compareVersion(version1: String, version2: String): Int {
    var revision1: Int
    var revision2: Int
    var index1 = 0
    var index2 = 0
    while (index1 < version1.length || index2 < version2.length) {
        revision1 = 0
        revision2 = 0
        while (index1 < version1.length && version1[index1] != '.') {
            revision1 = (revision1 * 10) + (version1[index1].digitToIntOrNull() ?: 0)
            index1++
        }
        index1++
        while (index2 < version2.length && version2[index2] != '.') {
            revision2 = (revision2 * 10) + (version2[index2].digitToIntOrNull() ?: 0)
            index2++
        }
        index2++
        if (revision1 < revision2) {
            return -1
        } else if (revision1 > revision2) {
            return 1
        }
    }
    return 0
}

private fun main() {

}
