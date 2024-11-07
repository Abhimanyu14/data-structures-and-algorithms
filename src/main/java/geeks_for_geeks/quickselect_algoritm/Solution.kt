package geeks_for_geeks.quickselect_algoritm

import data_structures_and_algorithms.searching.quickSelectDriver

fun main() {
    val input1 = intArrayOf(7, 10, 4, 3, 20, 15)
    for (i in 1..6) {
        println(quickSelectDriver(input1, i))
    }
}
