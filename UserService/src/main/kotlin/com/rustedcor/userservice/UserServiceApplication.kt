package com.rustedcor.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@RequestMapping("/api/users")
class UserServiceApplication{

	@GetMapping()
	fun helloWorld():String{
		return "Hello World";
	}

}

fun main(args: Array<String>) {
	runApplication<UserServiceApplication>(*args)
}
