package com.shds.codepusher.shared.secure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Order(1)
@Configuration
@EnableWebSecurity
open class SecureConfig {

  @Bean
  open fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.invoke {
      cors {
        configurationSource = corsConfigurationSource()
      }
      csrf { disable() }
      authorizeHttpRequests {
        authorize("/**", permitAll)
      }
    }

    return http.build()
  }

  @Bean
  fun corsConfigurationSource(): CorsConfigurationSource {
    val source = UrlBasedCorsConfigurationSource()
    val config = CorsConfiguration()
    config.allowCredentials = true
    config.allowedOrigins = listOf("http://localhost:3000")
    config.allowedMethods = listOf("GET", "POST", "PUT", "DELETE")
    config.allowedHeaders = listOf("*")
    source.registerCorsConfiguration("/**", config)
    return source
  }
}