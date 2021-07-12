package common.recursion

fun fibonacci(n: Int): Int {
    return if (n == 0 || n == 1) {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}

fun main() {
    val result = fibonacci(5)
    print(result)
}
