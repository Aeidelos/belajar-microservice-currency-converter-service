package id.my.micro.currencyconverter.entity

open class CurrencyConverter(
        val id: Int,
        val from: String,
        val to: String,
        val conversionMultiple: Double,
        val quantity: Double,
        val calculatedAmount: Double,
        val port: Int
)