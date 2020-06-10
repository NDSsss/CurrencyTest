package com.example.currencytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencytest.Currency.*
import kotlinx.android.synthetic.main.item_currency_eur.view.*
import kotlinx.android.synthetic.main.item_currency_rub.view.*
import kotlinx.android.synthetic.main.item_currency_usd.view.*


const val RUB_VIEW_HOLDER = 1
const val USD_VIEW_HOLDER = 2
const val EUR_VIEW_HOLDER = 3

class CurrencyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var checks: List<Check> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return when (checks[position].currency) {
            RUR -> RUB_VIEW_HOLDER
            USD -> USD_VIEW_HOLDER
            EUR -> EUR_VIEW_HOLDER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            RUB_VIEW_HOLDER -> RubVh(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_currency_rub, parent, false)
            )
            USD_VIEW_HOLDER -> UsdVh(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_currency_usd, parent, false)
            )
            EUR_VIEW_HOLDER -> EurVh(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_currency_eur, parent, false)
            )
            else -> throw IllegalArgumentException()
        }

    override fun getItemCount(): Int = checks.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RubVh -> holder.bind(checks[position])
            is UsdVh -> holder.bind(checks[position])
            is EurVh -> holder.bind(checks[position])
        }
    }
}

class RubVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(check: Check) {
        itemView.item_currency_rub_tv_name.text = check.name
        itemView.item_currency_rub_tv_sum.text = check.sum.toTwoDecimals()
    }
}

class UsdVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(check: Check) {
        itemView.item_currency_usd_tv_name.text = check.name
        itemView.item_currency_usd_tv_sum.text = check.sum.toTwoDecimals()
    }
}

class EurVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(check: Check) {
        itemView.item_currency_eur_tv_name.text = check.name
    }
}

fun Double.toTwoDecimals(): String = String.format("%.2f", this)