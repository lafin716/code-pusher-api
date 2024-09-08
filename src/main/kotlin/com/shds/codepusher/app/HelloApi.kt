package com.shds.codepusher.app

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloApi {
    @RequestMapping("/hello")
    fun hello(): String {
        return "Hello, World!"
    }
}