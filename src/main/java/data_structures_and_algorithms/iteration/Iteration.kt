package data_structures_and_algorithms.iteration

private fun main() {
    val list = listOf(1, 4, 6, 7, 9, 12, 35, 67, 79, 80)

    list.forEach {
        print("$it ")
    }
    println()

    list.forEachIndexed { index, item ->
        print("($index $item) ")
    }
    println()

    for (i in 0..list.lastIndex) {
        print("${list[i]} ")
    }
    println()

    for (i in 0..list.lastIndex step 2) {
        print("${list[i]} ")
    }
    println()

    for (i in list.lastIndex downTo 0) {
        print("${list[i]} ")
    }
    println()

    for (i in list.lastIndex downTo 0 step 2) {
        print("${list[i]} ")
    }
    println()
}
