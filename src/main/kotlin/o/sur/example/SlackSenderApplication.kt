/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package o.sur.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
@SpringBootApplication(scanBasePackages = ["o.sur.example"])
class SlackSenderApplication{
    companion object {
        @JvmStatic
        @Suppress("SpreadOperator")
        fun main(args: Array<String>) {
            runApplication<SlackSenderApplication>(*args)
        }
    }
}
