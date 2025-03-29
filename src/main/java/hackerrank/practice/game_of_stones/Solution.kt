package hackerrank.practice.game_of_stones

fun gameOfStones(n: Int): String {
    return if (n % 7 == 0 || n % 7 == 1) {
        "Second"
    } else {
        "First"
    }
}

private fun main() {
    (1..100).forEach {
        println("$it ${gameOfStones(it)}")
    }
}
