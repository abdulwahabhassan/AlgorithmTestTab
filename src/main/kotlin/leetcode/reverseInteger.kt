package leetcode

import kotlin.reflect.typeOf

fun main() {
    println(reverse(0))
}

fun reverse(x: Int): Int {

    val list = x.toString().filter {it != '-'}.reversed()

    return if (x.toString().length == list.length) {
        list.toInt()
    } else {
        ("-$list").toInt()
    }
}