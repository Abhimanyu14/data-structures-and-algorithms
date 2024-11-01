package leetcode.leetcode_700_to_799.leetcode_726_number_of_atoms

import java.util.Stack
import java.util.TreeMap


/**
 * leetcode - https://leetcode.com/problems/number-of-atoms/?envType=daily-question&envId=2024-07-14
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun countOfAtoms(formula: String): String {
    // For every index, store the valid multiplier
    val muls = IntArray(formula.length)
    var runningMul = 1

    // Stack to take care of nested formula
    val stack = Stack<Int>()
    stack.push(1)

    // Preprocess the formula and extract all multipliers
    var index = formula.length - 1
    var currNumber = StringBuilder()
    while (index >= 0) {
        if (Character.isDigit(formula[index])) {
            currNumber.insert(0, formula[index])
        } else if (Character.isAlphabetic(formula[index].code)) {
            currNumber = StringBuilder()
        } else if (formula[index] == ')') {
            val currMultiplier = if (currNumber.length > 0
            ) currNumber.toString().toInt() else 1
            runningMul *= currMultiplier
            stack.push(currMultiplier)
            currNumber = StringBuilder()
        } else if (formula[index] == '(') {
            runningMul /= stack.pop()
            currNumber = StringBuilder()
        }

        // For every index, store the valid multiplier
        muls[index] = runningMul
        index--
    }

    // Map to store the count of atoms
    val finalMap: MutableMap<String, Int> = HashMap()

    // Traverse left to right in the formula
    index = 0
    while (index < formula.length) {
        // If UPPER CASE LETTER, extract the entire atom
        if (Character.isUpperCase(formula[index])) {
            val currAtom = StringBuilder()
            currAtom.append(formula[index])
            val currCount = StringBuilder()
            index++
            while (index < formula.length &&
                Character.isLowerCase(formula[index])
            ) {
                currAtom.append(formula[index])
                index++
            }

            // Extract the count
            while (index < formula.length &&
                Character.isDigit(formula[index])
            ) {
                currCount.append(formula[index])
                index++
            }

            // Update the final map
            val count = if (currCount.isNotEmpty()) currCount.toString().toInt() else 1
            finalMap[currAtom.toString()] = finalMap.getOrDefault(currAtom.toString(), 0) +
                    count * muls[index - 1]
        } else {
            index++
        }
    }

    // Sort the final map
    val sortedMap = TreeMap(finalMap)

    // Generate the answer string
    val ans = StringBuilder()
    for (atom in sortedMap.keys) {
        ans.append(atom)
        if (sortedMap[atom]!! > 1) {
            ans.append(sortedMap[atom])
        }
    }

    return ans.toString()
}

private fun main() {

}
