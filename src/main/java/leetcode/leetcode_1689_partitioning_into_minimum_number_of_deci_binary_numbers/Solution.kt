package leetcode.leetcode_1689_partitioning_into_minimum_number_of_deci_binary_numbers

fun minPartitions(n: String): Int {
    var result = 0
    n.forEach {
        result = maxOf(result, it.toString().toInt())
    }
    return result
}

private fun main() {
    val input1 = "31"
    val input2 = "82734"
    val input3 = "27346209830709182346"
    println(minPartitions(input1))
    println(minPartitions(input2))
    println(minPartitions(input3))
}
