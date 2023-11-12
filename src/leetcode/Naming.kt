package leetcode

private fun main() {
    println(formatLeetcodeTitle("815. Bus Routes"))
    println(formatLeetcodeTitle("50. Pow(x, n)"))
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
