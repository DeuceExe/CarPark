package com.example.carpark.usecase

import com.example.carpark.enum.CarType

class CargoCar(brand: String, model: String) : BaseCar(CarType.Cargo, brand, model) {

    override fun fillTheTank(): String {
        println("$carType car $brand $model tank is filled")
        return super.fillTheTank()
    }

    override fun repairCar(): String {
        return super.repairCar()
    }
    
    fun sealingTheBody() {

    }


//    fun sortActivityByBodyType(cargoBodyType: CargoBodyType) {
//        when (cargoBodyType) {
//            CargoBodyType.Curtain -> {
//
//            }
//            CargoBodyType.Tank -> {
//
//            }
//            CargoBodyType.Refrigerator -> {
//
//            }
//        }
//    }
}