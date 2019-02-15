package com.henrj.measurement

import kotlin.system.measureTimeMillis

fun main() {
    var res = 0

    val loopTook = measureTimeMillis {
        for (i in 1..100_000_000) {
            res += i
        }
    }

    println("Execution time: $loopTook")
}
