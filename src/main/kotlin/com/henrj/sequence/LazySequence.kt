package com.henrj.sequence

fun main() {
    val seq = sequence {
        var a = 1
        var b = 1

        while (true) {
            yield(a)
            val tmp = a
            if (tmp > 10) continue
            a = b
            b += tmp
        }
    }

    println(seq.take(20).toList())
}
