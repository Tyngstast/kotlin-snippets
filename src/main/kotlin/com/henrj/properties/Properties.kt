package com.henrj.properties

/**
 * Property with setter
 */
private var prop: String = "..."
    set(value) {
        println("New value: $value")
        field = value
    }

/**
 * Lazy property
 */
val os: String by lazy {
    println("Computing...")
    System.getProperty("os.name") +
            " v" + System.getProperty("os.version") +
            " (" + System.getProperty("os.arch") + ")"

}

fun main() {
    for (i in 1..3)
        println(os)
}
