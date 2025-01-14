package leetcode.leetcode_2657_find_the_prefix_common_array_of_two_arrays

/**
 * leetcode - https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/?envType=daily-question&envId=2025-01-14
 *
 * Data Structure - Set and Arrays
 * Algorithm - Set intersection
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
    val result = IntArray(A.size)
    val setA = mutableSetOf<Int>()
    val setB = mutableSetOf<Int>()
    for (i in A.indices) {
        setA.add(A[i])
        setB.add(B[i])
        result[i] = (setA intersect setB).size
    }
    return result
}

private fun main() {

}
