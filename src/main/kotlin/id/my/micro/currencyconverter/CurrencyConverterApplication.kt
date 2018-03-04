package id.my.micro.currencyconverter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients("id.my.micro.currencyconverter")
@EnableDiscoveryClient
@EnableEurekaClient
class CurrencyConverterApplication

fun main(args: Array<String>) {
    runApplication<CurrencyConverterApplication>(*args)
}
