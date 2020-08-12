package com.bigangrydinosaur.blimpgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlimpClientApplication

fun main(args: Array<String>) {
	runApplication<BlimpClientApplication>(*args)
}
