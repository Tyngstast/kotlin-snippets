package com.henrj.properties

import kotlin.properties.Delegates

var observeMe by Delegates.observable("a") {
    property, oldValue, newValue ->
    println("${property.name} goes $oldValue -> $newValue")
}

fun main() {
    println("\n\nObservable property")
    observeMe = "bb"
    observeMe = "ccc"
    observeMe = "dddd"
}
