package com.henrj.properties

import kotlin.reflect.KProperty

var p1 by Prop("initial")

class Prop(var field: String) {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        println("You read me")
        return field
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("You write me")
        field = value
    }
}

fun main() {
    println(p1)
    p1 = "new value"
}
