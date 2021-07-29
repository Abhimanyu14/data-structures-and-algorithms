package kotlin_concepts

interface inter1 {
    fun demo() {
        println("This is from inter 1")
    }
}

interface inter2 {
    fun demo() {
        println("This is from inter 1")
    }
}

open class Parent1 {
    val x = 5
}

open class Parent2 {
    val y = 8
}

class Child : Parent1(), inter1, inter2 {


}

fun main() {
    val child = Child()
    println(child.x)
    // println(child.y)
}