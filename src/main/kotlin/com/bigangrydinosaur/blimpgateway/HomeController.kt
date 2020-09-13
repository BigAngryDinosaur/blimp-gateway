package com.bigangrydinosaur.blimpgateway

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.security.Principal
import javax.servlet.http.HttpServletResponse

data class UrlResponse(val code: String, val url: String)

@RestController
@RequestMapping("/")
@CrossOrigin
class HomeController(val urlService: BlimpService) {

    @GetMapping("user")
    fun user(user: Principal): Principal {
        return user
    }
}