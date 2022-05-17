package br.com.erudio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StartupTests

fun main(args: Array<String>) {
	runApplication<StartupTests>(*args)
}
