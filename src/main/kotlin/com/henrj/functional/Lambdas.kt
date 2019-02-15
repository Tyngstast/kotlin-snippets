package com.henrj.functional

fun main() {
    val numbers = (1..100).toList()

    val list = numbers
            .filter { it % 16 == 0 }
            .also { print(it) }
            .map { "0x" + it.toString(16) }

    println(list)

    repeat(6) {
        println(list)
    }
}

inline fun repeat(times: Int, body: (Int) -> Unit) {
    for (index in 0 until times) {
        body(index)
    }
}
