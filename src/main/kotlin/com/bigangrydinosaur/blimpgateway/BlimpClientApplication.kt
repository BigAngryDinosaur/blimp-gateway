package com.bigangrydinosaur.blimpgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
class BlimpClientApplication

fun main(args: Array<String>) {
	runApplication<BlimpClientApplication>(*args)
}
