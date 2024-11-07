package data_structures_and_algorithms.problems

// Reference
// https://www.radford.edu/~nokie/classes/360/dp-memoized.html

fun recursiveSolution(n: Int): Int {
    return if (n == 0 || n == 1) {
        n
    } else {
        recursiveSolution(n - 1) + recursiveSolution(n - 2)
    }
}

fun topDownSolution(n: Int, arr: IntArray): Int {
    if (n < 2 || arr[n] != 0) {
        return arr[n]
    }
    return topDownSolution(n - 1, arr) + topDownSolution(n - 2, arr)
}

fun topDownDriver(n: Int): Int {
    if (n == 0 || n == 1) {
        return n
    }
    val arr = IntArray(n + 1) { 0 }
    arr[1] = 1
    return topDownSolution(n, arr)
}

fun bottomUpSolution(n: Int): Int {
    if (n == 0 || n == 1) {
        return n
    }
    val arr = IntArray(n + 1) { 0 }
    arr[1] = 1
    for (i in 2..n) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }
    return arr[n]
}

fun main() {
    for (i in 0..10) {
        println(bottomUpSolution(i))
    }
}
