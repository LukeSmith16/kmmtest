package com.example.myapplication

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun doSomethingCool(): Int {
        return 12
    }

    fun anotherMethods() {

    }
}