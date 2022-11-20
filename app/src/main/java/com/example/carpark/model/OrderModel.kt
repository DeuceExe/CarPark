package com.example.carpark.model

import com.example.carpark.enum.CarBodyType
import com.example.carpark.enum.CarLicensePlate

data class OrderModel(
    val startPoint: String,
    val endPoint: String,
    val volume: Int?,
    val weight: Int?,
    val carType: CarBodyType,
    val numberOfPassengers: Int?,
    val loadUnloadCargo: Boolean,
)
