package id.my.micro.currencyconverter.proxy

import id.my.micro.currencyconverter.entity.CurrencyConverter
import org.springframework.cloud.netflix.ribbon.RibbonClient
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "currency-service")
@RibbonClient(name = "currency-service")
open interface CurrencyProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    fun retrieveExchangeValue(@PathVariable("from") from: String, @PathVariable("to") to: String):CurrencyConverter
}