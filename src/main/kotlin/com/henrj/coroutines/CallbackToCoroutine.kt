package com.henrj.coroutines

import kotlinx.coroutines.runBlocking
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class CallbackService(val name: String) {
    class Response(val from: CallbackService, val message: String)

    /**
     * Callback example
     */
    fun request(from: String, callback: (Response) -> Unit) {
        callback(Response(this, "Hi $from\n -- Yours, $name"))
    }
}

/**
 * Not recommended recursive way of sending many requests
 */
fun CallbackService.sendMany(vararg from: String, callback: (CallbackService.Response) -> Unit) {
    if (from.isEmpty()) return
    this.request(from[0]) { r ->
        callback(r)
        sendMany(*from.copyOfRange(1, from.size), callback = callback)
    }
}

fun main() {
    val s1 = CallbackService("1")
    val s2 = CallbackService("2")

    // callback hell
    s1.request(s2.name) { r1 ->
        println(r1.message)
        r1.from.request(s1.name) { r2 ->
            println(r2.message)
        }
    }

    s1.sendMany("a", "b", "c") { r ->
        println(r.message)
    }

    // Runs as if it is sequential code, but underneath it's all asynchronous
    runBlocking {
        val r1 = s1.requestSuspend(s2.name)
        println(r1)
        val r2 = s2.requestSuspend(s1.name)
        println(r2)

        for (from in listOf("a", "b", "c")) {
            println(s1.requestSuspend(from).message)
        }
    }
}

/**
 * Recommended approach using coroutines
 */
suspend fun CallbackService.requestSuspend(from: String) =
        suspendCoroutine<CallbackService.Response> { continuation ->
            try {
                request(from) { r ->
                    continuation.resume(r)
                }
            } catch (e: Throwable) {
                continuation.resumeWithException(e)
            }
        }
