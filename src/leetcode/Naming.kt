package leetcode

private fun main() {
    println(formatLeetcodeTitle("2391. Minimum Amount of Time to Collect Garbage"))
    println(formatLeetcodeTitle("1631. Path With Minimum Effort"))
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
