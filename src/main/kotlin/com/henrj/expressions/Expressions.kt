package com.henrj.expressions

import java.lang.RuntimeException

class Example(val a: Int, val b: String?, val c: Boolean)

fun main() {
    val ex = Example(1, null, true)

    with(ex) {
        println("a = $a, b = $b, c = $c")
    }

    val map = mapOf(
            "k1" to 1,
            "k2" to 2,
            "k3" to 3
    )

    for ((key, value) in map.entries) {
        println("$key -> $value")
    }

    val s = if (System.currentTimeMillis() % 2L == 0L) {
        println("Yay!")
        "Luck!"
    } else {
        "Not this time"
    }
    println(s)
}

fun whenUsage(e: Example) = when (e.a) {
    1, 3, 5 -> "Odd"
    in setOf(2, 4, 6) -> "Even"
    else -> "Too big"
}

fun nullSafety(str: String?): String? {
    println(str?.length)

    str?.forEach(::println)

    val s = str ?: return null
    if (str == null) return null
    if (str == null) throw RuntimeException("Unexpected null")
    if (str == null) error("Unexpected null")

    return ""
}
