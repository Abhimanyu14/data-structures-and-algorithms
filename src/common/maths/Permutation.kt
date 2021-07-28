package common.maths

fun factorial(n: Int): Int {
    if (n <= 1) {
        return 1
    }
    return n * factorial(n - 1)
}

fun combination(n: Int, r: Int): Int {
    return factorial(n) / (factorial(r) * factorial(n - r))
}
