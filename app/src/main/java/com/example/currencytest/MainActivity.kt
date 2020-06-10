package com.example.currencytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val currencyAdapter = CurrencyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        act_main_rv_currency.adapter = currencyAdapter
        currencyAdapter.checks = generateChecks()
    }

    private fun generateChecks(): List<Check> {
        val resultList = arrayListOf<Check>()
        for (i in 0..33) {
            resultList.add(
                when (Random.nextInt(0, 3)) {
                    0 -> {
                        Check("RUR name$i", Currency.RUR, Random.nextDouble(0.0, 100.0))
                    }
                    1 -> {
                        Check("USD name$i", Currency.USD, Random.nextDouble(0.0, 100.0))
                    }
                    else -> {
                        Check("EUR name$i", Currency.EUR, Random.nextDouble(0.0, 100.0))
                    }
                }
            )
        }
        return resultList.sortedBy { it.currency }
    }
}