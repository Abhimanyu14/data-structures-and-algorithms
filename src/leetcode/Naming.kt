package leetcode

private fun main() {
    val name = "65. Valid Number"
        .replace("-", "_")
        .replace("(", "")
        .replace(")", "")
        .replace(".", "")
        .replace("'", "_")
        .replace(" ", "_")
        .lowercase()
    println("leet_$name")
}
