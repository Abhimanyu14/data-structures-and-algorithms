package codility.lesson2_arrays

private fun solution(A: IntArray): Int {
    var result = 0
    A.forEach {
        result = result xor it
    }
    return result
}
