package leetcode.leetcode_649_dota2_senate

/**
 * leetcode - https://leetcode.com/problems/dota2-senate/
 *
 * Using set
 *
 * Stats
 * Runtime: 208 ms, faster than 52.25%
 * Memory Usage: 38.9 MB, less than 35.14%
 */
private fun predictPartyVictory(senate: String): String {
    val eliminated = mutableSetOf<Int>()
    var tempRadiantEliminatedCount = 0
    var tempDireEliminatedCount = 0
    var radiantCount = 0
    var direCount = 0
    senate.forEach {
        if (it == 'R') {
            radiantCount++
        } else {
            direCount++
        }
    }

    while (true) {
        senate.forEachIndexed { index, item ->
            if (!eliminated.contains(index)) {
                if (item == 'R') {
                    if (tempRadiantEliminatedCount > 0) {
                        tempRadiantEliminatedCount--
                        radiantCount--
                        eliminated.add(index)
                    } else {
                        if ((direCount - tempDireEliminatedCount) == 0) {
                            return "Radiant"
                        } else {
                            tempDireEliminatedCount++
                        }
                    }
                } else {
                    if (tempDireEliminatedCount > 0) {
                        tempDireEliminatedCount--
                        direCount--
                        eliminated.add(index)
                    } else {
                        if ((radiantCount - tempRadiantEliminatedCount) == 0) {
                            return "Dire"
                        } else {
                            tempRadiantEliminatedCount++
                        }
                    }
                }
            }
        }
    }
}

private fun main() {
    "RRDDDDDDDRRDRRDDRRRR"
}
