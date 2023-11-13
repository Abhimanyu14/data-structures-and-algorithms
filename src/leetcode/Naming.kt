package leetcode

private fun main() {
    println(formatLeetcodeTitle("2785. Sort Vowels in a String"))
    println(formatLeetcodeTitle("52. N-Queens II"))
}

private fun formatLeetcodeTitle(@Suppress("SameParameterValue") title: String): String {
    val result = title
        .replace("-", "_")
        .replace("(", "")
        .replace(")", "")
        .replace(".", "")
        .replace("'", "_")
        .replace(" ", "_")
        .lowercase()
    return "leet_$result"
}
