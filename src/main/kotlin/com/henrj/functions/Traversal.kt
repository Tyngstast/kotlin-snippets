package com.henrj.functions

fun main() {
    val root = Container(
            Text("a"),
            Container(
                    Text("b"),
                    Container(
                            Text("c"),
                            Text("d")
                    ),
                    Text("e")
            ),
            Text("f")
    )

    println(root.extractText())
}

/**
 * Extension function with an inner function
 */
private fun Element.extractText(): String {
    val sb = StringBuilder()
    fun extractText(e: Element) {
        // sealed class ensures we do not need a default case. e can only be Container or Text
        when (e) {
            is Text -> sb.append(e.text)
            is Container -> e.children.forEach(::extractText)
        }
    }
    extractText(this)

    return sb.toString()
}

sealed class Element
class Container(vararg val children: Element): Element()
class Text(val text: String): Element()


