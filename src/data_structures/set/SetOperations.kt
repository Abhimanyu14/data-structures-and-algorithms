package data_structures.set

fun main() {
    val set1 = setOf(1, 2, 3)
    val set2 = setOf(3, 4, 5)

    val intersection = set1 intersect set2
    println("intersection $intersection")

    val difference2From1 = set1 - set2
    println("difference2From1 $difference2From1")

    val difference1From2 = set2 - set1
    println("difference1From2 $difference1From2")

    val union = set1 union set2
    println("union $union")

    println(set1 + 23) // Plus
    println(set1 - 45) // Minus
    println(set1 - 2)
    println(set1)
}
