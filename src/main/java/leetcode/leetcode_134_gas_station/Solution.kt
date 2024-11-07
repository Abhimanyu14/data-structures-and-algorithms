package leetcode.leetcode_134_gas_station

/**
 * leetcode - https://leetcode.com/problems/gas-station/
 *
 * Using single pass
 *
 * Stats
 * Runtime: 596 ms, faster than 70.59%
 * Memory Usage: 74.3 MB, less than 41.18%
 */
private fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var currentTank = 0
    var totalTank = 0
    var start = 0
    for (i in 0..gas.lastIndex) {
        currentTank += gas[i] - cost[i]
        totalTank += gas[i] - cost[i]
        if (currentTank < 0) {
            currentTank = 0
            start = i + 1
        }
    }
    return if (totalTank >= 0) {
        start
    } else {
        -1
    }
}

/**
 * leetcode - https://leetcode.com/problems/gas-station/
 *
 * Using array manipulation and two pass
 *
 * Stats
 * Runtime: 681 ms, faster than 37.25%
 * Memory Usage: 76.1 MB, less than 9.80%
 */
private fun canCompleteCircuitUsingTwoPass(gas: IntArray, cost: IntArray): Int {
    for (i in 0..gas.lastIndex) {
        gas[i] = gas[i] - cost[i]
    }
    var currentSum = 0
    var pos = 0
    for (i in 0..gas.lastIndex) {
        if (currentSum < 0) {
            currentSum = 0
            pos = i % gas.size
        }
        currentSum += gas[i]
    }
    if (currentSum < 0) {
        return -1
    }
    for (i in 0 until pos) {
        currentSum += gas[i]
        if (currentSum < 0) {
            return -1
        }
    }
    return pos
}

/**
 * leetcode - https://leetcode.com/problems/gas-station/
 *
 * Using brute force
 *
 * Stats
 * Time limit exceeded
 */
fun canCompleteCircuitUsingBruteForce(gas: IntArray, cost: IntArray): Int {
    var currentGas: Int
    var complete: Boolean
    for (i in 0..gas.lastIndex) {
        complete = true
        currentGas = gas[i]
        for (j in i..(cost.lastIndex + i)) {
            if (currentGas - cost[j % cost.size] < 0) {
                complete = false
                break
            }
            currentGas = currentGas - cost[j % cost.size] + gas[(j + 1) % cost.size]
        }
        if (complete) {
            return i
        }
    }
    return -1
}

private fun main() {

}
