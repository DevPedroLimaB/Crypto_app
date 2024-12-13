package com.example.crypto_app.Activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto_app.Adapter.CryptoAdapter
import com.example.crypto_app.Adapter.StockAdapter
import com.example.crypto_app.Model.Model
import com.example.crypto_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private val lineData= arrayListOf(1000,1100,1200,1100)
        private val lineData2= arrayListOf(2100,2000,1900,2000)
        private val lineData3= arrayListOf(900,1100,1200,1000,1150)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = android.graphics.Color.WHITE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        cryptoList()
        stockList()

    }

    private fun stockList() {
       binding.stockView.layoutManager=
           LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val domainArrayList= arrayListOf(
            Model("NASDAQ100", "BTX", 1234.12, 2.13,lineData, 1234.12, 0.123),
            Model("S&P 500", "ETH", 2134.12, -1.13,lineData2, 6545.12, 0.123),
            Model("Dow Jones", "ROX", 4324.12, 0.72,lineData3, 2389.12, 0.123)
        )
        binding.stockView.adapter=StockAdapter(domainArrayList)
    }

    private fun cryptoList() {
                binding.cryptoView.layoutManager=
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                //this is sample data for exemple

                val domainArrayList= arrayListOf(
                    Model("bitcoin", "BTX", 1234.12, 2.13,lineData, 1234.12, 0.123),
                    Model("etherium", "ETH", 2134.12, -1.13,lineData2, 6545.12, 0.123),
                    Model("trox", "ROX", 4324.12, 0.72,lineData3, 2389.12, 0.123)
                )
                binding.cryptoView.adapter=CryptoAdapter(domainArrayList)
            }
    }
