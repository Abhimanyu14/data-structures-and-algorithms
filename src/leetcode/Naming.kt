package leetcode

private fun main() {
    println(formatLeetcodeTitle("2300. Successful Pairs of Spells and Potions"))
    println(formatLeetcodeTitle("860. Lemonade Change"))
    println(formatLeetcodeTitle("836. Rectangle Overlap"))
    println(formatLeetcodeTitle("824. Goat Latin"))
    println(formatLeetcodeTitle("748. Shortest Completing Word"))
    println(formatLeetcodeTitle("705. Design HashSet"))
    println(formatLeetcodeTitle("697. Degree of an Array"))
    println(formatHackerrankTitle("Is This a Binary Search Tree?"))
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
        .filter { it.isLetter() || it.isDigit() || it == '_' }
    return "leet_$result"
}

private fun formatHackerrankTitle(@Suppress("SameParameterValue") title: String): String {
    return title
        .replace("-", "_")
        .replace("(", "")
        .replace(")", "")
        .replace(".", "")
        .replace("'", "_")
        .replace(" ", "_")
        .lowercase()
        .filter { it.isLetter() || it == '_' }
}
