package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("hello")
class HelloController {
    @GetMapping("/wd")
    fun index(model: Model): String {
        model.addAttribute("message", "はろーわーるど")
        return "index"
    }
}

@RestController
@RequestMapping("greeter")
class GreeterController {
    var greeter: Greeter? = null
        @Autowired
        set(value) {
            field  = value
        }

    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse{
        return HelloResponse("Hello ${name}")
    }

    @GetMapping("/hello/{name}")
    fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse("Hello $name")
    }

    @PostMapping("/hello")
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse {
        return HelloResponse("Hello ${request.name}")
    }

    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String): HelloResponse {
        val message = greeter?.sayHello(name)
        return HelloResponse(message)
    }
}
data class HelloResponse(val message: String?)
data class HelloRequest(val name: String)

interface Greeter {
    fun sayHello(name: String): String
}

@Component
class GreeterImpl: Greeter {
    override fun sayHello(name: String): String = "Hello $name"
}