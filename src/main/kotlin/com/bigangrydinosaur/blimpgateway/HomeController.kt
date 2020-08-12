package com.bigangrydinosaur.blimpgateway

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.servlet.http.HttpServletResponse

data class UrlRequest(val url: String)
data class UrlResponse(val code: String, val url: String)

@RestController
@RequestMapping("/")
@CrossOrigin(origins = ["http://localhost:3000"])
class HomeController(val urlService: BlimpService) {

    @GetMapping("{code}")
    fun goToUrl(response: HttpServletResponse, @PathVariable("code") code: String) {
        val url = urlService.getUrl(code) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        response.sendRedirect(url.url)
    }

    @PostMapping("api/url")
    fun shortenUrl(@RequestBody urlRequest: UrlRequest): UrlResponse {
        return urlService.shortenUrl(urlRequest.url)
                ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create url")
    }
}