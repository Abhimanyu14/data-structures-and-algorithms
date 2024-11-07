package leetcode.leetcode_40_combination_sum_ii

import java.util.Arrays
import java.util.LinkedList


/**
 * leetcode - https://leetcode.com/problems/combination-sum-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    fun backtrack(
        answer: MutableList<List<Int>>,
        tempList: MutableList<Int>,
        candidates: IntArray,
        totalLeft: Int,
        index: Int,
    ) {
        if (totalLeft < 0) return
        else if (totalLeft == 0) { // Add to the answer array, if the sum is equal to target.
            answer.add(ArrayList(tempList))
        } else {
            var i = index
            while (i < candidates.size && totalLeft >= candidates[i]
            ) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    i++
                    continue
                }
                // Add it to tempList.
                tempList.add(candidates[i])
                // Check for all possible scenarios.
                backtrack(
                    answer,
                    tempList,
                    candidates,
                    totalLeft - candidates[i],
                    i + 1
                )
                // Backtrack the tempList.
                tempList.removeAt(tempList.size - 1)
                i++
            }
        }
    }

    val list: MutableList<List<Int>> = LinkedList()
    Arrays.sort(candidates)
    backtrack(list, ArrayList(), candidates, target, 0)
    return list
}

private fun main() {

}
