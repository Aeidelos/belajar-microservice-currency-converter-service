package id.my.micro.currencyconverter.controller

import id.my.micro.currencyconverter.entity.CurrencyConverter
import id.my.micro.currencyconverter.proxy.CurrencyProxy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.http.ResponseEntity
import java.util.HashMap

@RestController
class CurrencyConverterController(@Autowired val currencyProxy: CurrencyProxy) {
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    open fun convertCurrency(@PathVariable from:String, @PathVariable to:String, @PathVariable quantity:Double)
            : CurrencyConverter {
        val uriVariables = HashMap<String, String>()
        uriVariables["from"] = from
        uriVariables["to"] = to
        val response = currencyProxy.retrieveExchangeValue(from, to)
        return CurrencyConverter(response!!.id, from, to, response!!.conversionMultiple, quantity,
                quantity * response!!.conversionMultiple, response.port)
    }
}