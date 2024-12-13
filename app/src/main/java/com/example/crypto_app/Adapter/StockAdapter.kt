package com.example.crypto_app.Adapter

import android.graphics.Color
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crypto_app.Model.Model
import com.example.crypto_app.databinding.ViewholderCryptoBinding
import com.example.crypto_app.databinding.ViewholderStockBinding

class StockAdapter(private val dataList:ArrayList<Model>):
RecyclerView.Adapter<StockAdapter.ViewHolder>(){

    private val formatter=DecimalFormat("###,###,###,###,##")

    class ViewHolder (val binding: ViewholderStockBinding):RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockAdapter.ViewHolder {
        val binding=ViewholderStockBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockAdapter.ViewHolder, position: Int) {
        val item=dataList[position]
        holder.binding.apply {
            cryptoNameTxt.text=item.name
            cryptoPriceTxt.text="$${formatter.format(item.price)}"
            changePercentTxt.text="${item.changePercent}%"
            sparkLineLayout.setData(item.lineData)

            val changeColor=when{
                item.changePercent>0-> Color.parseColor("#12c737")
                item.changePercent<0-> Color.parseColor("#ff0000")
                else-> Color.WHITE
            }
            changePercentTxt.setTextColor(changeColor)
            sparkLineLayout.sparkLineColor=changeColor

            val picName=when(item.name){
                "NASDAQ100"-> "stock_1"
                "S&P 500"-> "stock_2"
                "Dow Jones"-> "stock_3"
                else -> ""
            }

            val drawableReousrceId=holder.itemView.context.resources.getIdentifier(
               picName,"drawable",holder.itemView.context.packageName
            )

            Glide.with(holder.itemView.context)
                .load(drawableReousrceId)
                .into(logoImg)
        }
    }

    override fun getItemCount(): Int =dataList.size
}