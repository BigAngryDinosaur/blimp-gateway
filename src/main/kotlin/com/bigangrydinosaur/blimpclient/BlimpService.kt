package com.bigangrydinosaur.blimpclient

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class BlimpService {

    fun shortenUrl(fullUrl: String): UrlResponse? {
        val client = WebClient.create("http://localhost:8083")
        return client.post()
                .uri("/api/url/")
                .bodyValue(fullUrl)
                .retrieve()
                .bodyToMono(UrlResponse::class.java)
                .block()
    }

    fun getUrl(code: String): UrlResponse? {
        val client = WebClient.create("http://localhost:8083")
        return client.get()
                .uri("/api/url/${code}")
                .retrieve()
                .bodyToMono(UrlResponse::class.java)
                .block()
    }
}