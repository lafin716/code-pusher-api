package com.shds.codepusher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CodePusherApplication

fun main(args: Array<String>) {
  runApplication<CodePusherApplication>(*args)
}
