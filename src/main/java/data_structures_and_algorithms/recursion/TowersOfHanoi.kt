package data_structures_and_algorithms.recursion

fun towersOfHanoi(n: Int, source: String, auxiliary: String, destination: String) {
    if (n == 1) {
        println("$source -> $destination")
    } else {
        towersOfHanoi(n - 1, source, destination, auxiliary)
        println("$source -> $destination")
        towersOfHanoi(n - 1, auxiliary, source, destination)
    }
}

private fun main() {
    towersOfHanoi(3, "A", "B", "C")
}
