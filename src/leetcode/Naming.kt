package leetcode

private fun main() {
    println(formatLeetcodeTitle("1514. Path with Maximum Probability"))
    println(formatLeetcodeTitle("787. Cheapest Flights Within K Stops"))
    println(formatLeetcodeTitle("685. Redundant Connection II"))
    println(formatLeetcodeTitle("444. Sequence Reconstruction"))
    println(formatLeetcodeTitle("2101. Detonate the Maximum Bombs"))
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
