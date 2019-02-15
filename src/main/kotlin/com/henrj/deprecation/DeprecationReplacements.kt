package com.henrj.deprecation

import java.util.stream.Collectors

fun main() {
    joinStrings(", ", listOf("one", "two", "three"))
}

@Deprecated("Use values.jointToString(sep)",
        level = DeprecationLevel.WARNING,
        replaceWith = ReplaceWith("values.joinToString(sep)",
                imports = ["java.lang.String"])) // just to demonstrate imports
fun joinStrings(sep: String, values: List<String>): String {
    return values.stream()
            .collect(Collectors.joining(sep))
}
