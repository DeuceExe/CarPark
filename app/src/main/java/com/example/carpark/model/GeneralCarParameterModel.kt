package com.example.carpark.model

import com.example.carpark.enum.CarBodyType
import com.example.carpark.enum.CarLicensePlate
import com.example.carpark.enum.FuelType

data class GeneralCarParameterModel(
    val carNumber: CarLicensePlate,
    val releaseDate: Int,
    val brand: String,
    val model: String,
    val carBody: CarBodyType,
    val fuelType: FuelType,
    val fuelConsumption: Double,
    val orderList: ArrayList<OrderModel> = arrayListOf()
)