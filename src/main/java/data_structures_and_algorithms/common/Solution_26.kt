package data_structures_and_algorithms.common

/**
 * Prime check
 *
 * Using iteration
 */
private fun isPrime(n: Int): Boolean {
    for (i in 2..n / 2) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

private fun main() {
    println(isPrime(2))
    println(isPrime(3))
    println(isPrime(4))
    println(isPrime(5))
}
