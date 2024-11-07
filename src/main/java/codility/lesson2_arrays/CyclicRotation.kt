package codility.lesson2_arrays

private fun solution(A: IntArray, K: Int): IntArray {
    if (A.isEmpty() || K == 0) {
        return A
    }
    val result = IntArray(A.size)
    val start = K % A.size
    repeat(A.size) {
        result[it] = A[(A.lastIndex - start + 1 + it) % A.size]
    }
    return result
}

