package algorithms.recursion

fun combination(n: Int, k: Int): Int {
    return if (k == 0 || k == n) {
        1
    } else {
        combination(n - 1, k) + combination(n - 1, k - 1)
    }
}

fun main() {
    val result = combination(4, 2)
    print(result)
}
