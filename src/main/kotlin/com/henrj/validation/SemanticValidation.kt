package com.henrj.validation

fun main() {
    println(
            join(",", listOf("one", "two", "three"))
    )
}

fun join(sep: String, values: List<String>): String {
    require(sep.length < 2) { "separator must be single character. sep: $sep" }

    return values.joinToString(sep)
}
