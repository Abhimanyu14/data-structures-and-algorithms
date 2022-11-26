package youtube.others

/**
 * Using Hashset
 * Time complexity - O(n)
 * Memory complexity - O(n)
 */
private fun firstRecurringCharacter(s: String): Char? {
    val set = HashSet<Char>()
    for (i in 0..s.lastIndex) {
        if (set.contains(s[i])) {
            return s[i]
        } else {
            set.add(s[i])
        }
    }
    return null
}

fun main() {
    println(firstRecurringCharacter("ABCA"))
    println(firstRecurringCharacter("BCABA"))
    println(firstRecurringCharacter("ABC"))
}
