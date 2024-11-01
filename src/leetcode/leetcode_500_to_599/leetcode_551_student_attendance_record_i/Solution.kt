package leetcode.leetcode_500_to_599.leetcode_551_student_attendance_record_i

/**
 * Using loop
 *
 * Stats
 * Runtime: 283 ms, faster than 19.05%
 * Memory Usage: 34.7 MB, less than 19.05%
 */
private fun checkRecord(s: String): Boolean {
    var absentCount = 0
    var currentLateCount = 0
    for (i in s.indices) {
        if (s[i] == 'A') {
            absentCount++
            if (absentCount == 2) {
                return false
            }
            currentLateCount = 0
        } else if (s[i] == 'L') {
            currentLateCount++
            if (currentLateCount == 3) {
                return false
            }
        } else {
            currentLateCount = 0
        }
    }
    return true
}

private fun main() {

}
