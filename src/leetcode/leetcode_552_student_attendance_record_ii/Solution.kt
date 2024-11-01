package leetcode.leetcode_552_student_attendance_record_ii

/**
 * leetcode - https://leetcode.com/problems/student-attendance-record-ii/?envType=daily-question&envId=2024-05-26
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun checkRecord(n: Int): Int {
    val MOD = 1000000007
    // Cache to store current sub-problem results.
    val dpCurrState = Array(2) { IntArray(3) }
    // Cache to store next sub-problem results.
    var dpNextState = Array(2) { IntArray(3) }

    // Base case: there is 1 string of length 0 with zero 'A' and zero 'L'.
    dpCurrState[0][0] = 1

    // Iterate on smaller sub-problems and use the current smaller sub-problem
    // to generate results for bigger sub-problems.
    for (len in 0..<n) {
        for (totalAbsences in 0..1) {
            for (consecutiveLates in 0..2) {
                // Store the count when 'P' is chosen.
                dpNextState[totalAbsences][0] = (dpNextState[totalAbsences][0] +
                        dpCurrState[totalAbsences][consecutiveLates]
                        ) % MOD
                // Store the count when 'A' is chosen.
                if (totalAbsences < 1) {
                    dpNextState[totalAbsences + 1][0] = (dpNextState[totalAbsences + 1][0] +
                            dpCurrState[totalAbsences][consecutiveLates]
                            ) % MOD
                }
                // Store the count when 'L' is chosen.
                if (consecutiveLates < 2) {
                    dpNextState[totalAbsences][consecutiveLates + 1] =
                        (dpNextState[totalAbsences][consecutiveLates + 1] +
                                dpCurrState[totalAbsences][consecutiveLates]
                                ) % MOD
                }
            }
        }

        // Next state sub-problems will become current state sub-problems in the next iteration.
        System.arraycopy(dpNextState, 0, dpCurrState, 0, dpCurrState.size)
        // Next state sub-problem results will reset to zero.
        dpNextState = Array(2) { IntArray(3) }
    }

    // Sum up the counts for all combinations of length 'n' with different absent and late counts.
    var count = 0
    for (totalAbsences in 0..1) {
        for (consecutiveLates in 0..2) {
            count = (count + dpCurrState[totalAbsences][consecutiveLates]) % MOD
        }
    }
    return count
}

private fun main() {

}
