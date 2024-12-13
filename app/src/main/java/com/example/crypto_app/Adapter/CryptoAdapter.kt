package com.example.crypto_app.Adapter

import android.graphics.Color
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crypto_app.Model.Model
import com.example.crypto_app.databinding.ViewholderCryptoBinding

class CryptoAdapter(private val dataList:ArrayList<Model>):
RecyclerView.Adapter<CryptoAdapter.ViewHolder>(){

    private val formatter=DecimalFormat("###,###,###,###,##")

    class ViewHolder (val binding: ViewholderCryptoBinding):RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoAdapter.ViewHolder {
        val binding=ViewholderCryptoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoAdapter.ViewHolder, position: Int) {
        val item=dataList[position]
        holder.binding.apply {
            cryptoNameTxt.text=item.name
            cryptoPriceTxt.text="$${formatter.format(item.price)}"
            changePercentTxt.text="${item.changePercent}%"
            propertySizeTxt.text="${item.propertySize}${item.symbol}"
            propertyAmountTxt.text="$${formatter.format(item.propertyAmount)}"
            sparkLineLayout.setData(item.lineData)

            val changeColor=when{
                item.changePercent>0-> Color.parseColor("#12c737")
                item.changePercent<0-> Color.parseColor("#ff0000")
                else-> Color.WHITE
            }
            changePercentTxt.setTextColor(changeColor)
            sparkLineLayout.sparkLineColor=changeColor

            val drawableReousrceId=holder.itemView.context.resources.getIdentifier(
                item.name,"drawable",holder.itemView.context.packageName
            )

            Glide.with(holder.itemView.context)
                .load(drawableReousrceId)
                .into(logoImg)
        }
    }

    override fun getItemCount(): Int =dataList.size
}