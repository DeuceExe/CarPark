package com.example.carpark.usecase

import com.example.carpark.enum.CarType

class PassengerCar(brand: String, model: String) : BaseCar(CarType.Passenger, brand, model) {

    override fun fillTheTank(): String {
        println("$carType car $brand $model tank is filled")
        return super.fillTheTank()
    }

    override fun repairCar() = super.repairCar()

    fun disinfectTheSalon() {}
}