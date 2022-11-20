package com.example.carpark.usecase

import com.example.carpark.enum.CarType

class PassengerCargoCar(brand: String, model: String) : BaseCar(CarType.CargoPassenger, brand, model) {

    override fun fillTheTank(): String {
        println("$carType car $brand $model tank is filled")
        return super.fillTheTank()
    }

    override fun repairCar(): String {
        return super.repairCar()
    }

    fun dismantleCargoAreas() {

    }
}