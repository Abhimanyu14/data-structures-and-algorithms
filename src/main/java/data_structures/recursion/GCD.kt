package data_structures.recursion

/**
 * Euclidean algorithm
 */
private fun gcd(a: Int, b: Int): Int {
    return when {
        b == 0 -> a
        a == 0 -> b
        else -> gcd(b, a % b)
    }
}

private fun main() {
    val result = gcd(10, 25)
    print(result)
}
