package o.sur.example.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean

@Bean
fun enableDefaultServlet(): WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    return WebServerFactoryCustomizer { factory: ConfigurableServletWebServerFactory ->
        factory.setRegisterDefaultServlet(true)
    }
}

@Bean
fun objectMapper(): ObjectMapper = ObjectMapper()