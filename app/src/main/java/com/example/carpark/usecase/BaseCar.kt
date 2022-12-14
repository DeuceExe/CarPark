package com.example.carpark.usecase

import com.example.carpark.enum.CarType

abstract class BaseCar(val carType: CarType, val brand: String, val model: String) {

    open fun fillTheTank() = "$carType car $brand $model tank is filled"

    open fun repairCar() = "$carType car is repaired"

    open fun checkReadinessForOrder() {}
}