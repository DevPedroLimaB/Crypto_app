package com.example.crypto_app.Model

import android.util.Property
import android.util.Size
import java.time.temporal.TemporalAmount

 class Model (
    var name:String ,
    var symbol:String,
    var price:Double,
    var changePercent:Double,
    var lineData: ArrayList<Int>,
    var propertyAmount: Double,
    var propertySize: Double
    )