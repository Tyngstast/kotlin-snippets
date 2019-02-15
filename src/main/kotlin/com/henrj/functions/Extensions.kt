package com.henrj.functions

/**
 * Extension function + default parameter
 */
fun String.getFirstWord(separator: String = ","): String {
    val index = this.indexOf(separator)
    return if (index < 0) this else this.substring(0, index)
}

/**
 * Extension value function
 */
val String.firstWord: String
    get() {
        val index = indexOf(" ")
        return if (index < 0) this else substring(0, index)
    }

fun main() {
    println("Jane Doe".getFirstWord(separator = " "))
    println("Jane Doe".firstWord)
}

