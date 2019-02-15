package com.henrj.functions

fun main() {
    val firstUser = User("Jane", "jane@mail.com")
    val secondUser = User("Bob", "john@mail.com")

    run {
        if (firstUser.name.length > secondUser.name.length) firstUser else secondUser
    }.printUser()

    with(firstUser) {
        email = "newemail@mail.com"
        "email is now $email"
    }.println()

    firstUser.run {
        email = "changedagain@mail.com"
        "email is now $email"
    }.println()

    // mostly just inferior to run
    firstUser.let {
        it.email = "really@mail.com"
        "email is now ${it.email}"
    }.println()

    // applies changes and returns this
    secondUser.apply {
        email = "example@mail.com"
    }.printUser()

    secondUser.also {
        it.email = "changedinalso@mail.com"
    }.printUser()

}

data class User(var name: String, var email: String) {
    fun printUser() = println(this.toString())
}

fun String.println() = println(this)
