package com.example.carpark

import com.example.carpark.enum.CarBodyType
import com.example.carpark.enum.CarLicensePlate
import com.example.carpark.enum.FuelType
import com.example.carpark.model.*
import kotlin.collections.ArrayList

fun main(){

    var orderList: ArrayList<OrderModel> = arrayListOf(
        OrderModel("Minsk", "Brest", null,  null,
            CarBodyType.Passenger, 3,true),
        OrderModel("Jopa", "Mira", null,  null,
            CarBodyType.Passenger, 2,true),
        OrderModel("Pinsk", "Gomel", 50,  100,
            CarBodyType.Curtain, null,false),
        OrderModel("Minsk", "Baranovichi", 35,  100,
            CarBodyType.Refrigerator, 2,true)
    )

    var passengerCarPark: Array<PassengerCarModel> = arrayOf(
        PassengerCarModel(
            GeneralCarParameterModel(CarLicensePlate.AudiSQ2,2018, "Audi", "SQ2",
            CarBodyType.Passenger, FuelType.Gasoline, 6.2),1),
        PassengerCarModel(
            GeneralCarParameterModel(CarLicensePlate.MercedesA220,2016, "Mercedes", "A220",
            CarBodyType.Passenger, FuelType.Gasoline, 8.8),6),
        PassengerCarModel(
            GeneralCarParameterModel(CarLicensePlate.LexusLX570,2015, "Lexus", "LX570",
            CarBodyType.Passenger, FuelType.Gasoline, 5.7),4)
    )

    var cargoCarPark: Array<CargoCarModel> = arrayOf(
        CargoCarModel(
            GeneralCarParameterModel(CarLicensePlate.RenaultMaster,2004, "Renault",
                "Master", CarBodyType.Refrigerator,
                FuelType.Diesel, 6.2),1050.0, 620.0),
        CargoCarModel(
            GeneralCarParameterModel(CarLicensePlate.CitroenC25,2007, "Citroen",
                "C25", CarBodyType.Tank,
                FuelType.Diesel, 6.2),1120.0, 700.0),
        CargoCarModel(
            GeneralCarParameterModel(CarLicensePlate.CitroenJumper, 2005, "Citroen",
                "Jumper", CarBodyType.Curtain,
                FuelType.Gasoline, 6.2),1200.0, 500.0)
    )

    var cargoPassengerPark: Array<CargoPassengerModel> = arrayOf(
        CargoPassengerModel(
            GeneralCarParameterModel(CarLicensePlate.RenaultTrafic,1999, "Renault",
                "Trafic", CarBodyType.Curtain,
                FuelType.Diesel, 6.2),900.0, 350.0, 4),
        CargoPassengerModel(
            GeneralCarParameterModel(CarLicensePlate.OpelVivaro,2003, "Opel",
                "Vivaro", CarBodyType.Curtain,
                FuelType.Diesel, 6.2),870.0, 310.0, 2),
        CargoPassengerModel(
            GeneralCarParameterModel(CarLicensePlate.MercedesSprinter,2000, "Mercedes",
                "Sprinter", CarBodyType.Refrigerator,
                FuelType.Diesel, 6.2),600.0, 250.0,3)
    )
    requestOrderInformation(orderList)
    addCargoCarOrder(cargoCarPark, orderList)
    addCargoPassengerCarOrder(cargoPassengerPark, orderList)
    transferOrder(passengerCarPark, passengerCarPark)
}

fun addCargoCarOrder(car: Array<CargoCarModel>, order: ArrayList<OrderModel>){
    var orderIndex: Array<Int> = arrayOf()
    for(carCounter in car.indices){
        for(orderCounter in order.indices){
            val weight = order[orderCounter].weight
            val volume = order[orderCounter].volume
            if(orderCounter < order.size && weight != null && volume != null) {
                if (car[carCounter].generalParameters.carBody == order[orderCounter].carType &&
                    car[carCounter].freeLoadCapacity >= weight &&
                    car[carCounter].volume >= volume
                ) {
                    car[carCounter].generalParameters.orderList.add(order[orderCounter])
                    car[carCounter].freeLoadCapacity.minus(weight)
                    car[carCounter].volume.minus(volume)
                    orderIndex += orderCounter
                }
            }
        }
        if(orderIndex.isNotEmpty()){
            for(indexCounter in orderIndex.indices) {
                order.removeAt(orderIndex.sortedDescending()[indexCounter])
            }
            orderIndex = arrayOf()
        }
    }
}

fun addCargoPassengerCarOrder(car: Array<CargoPassengerModel>, order: ArrayList<OrderModel>){
    var orderIndex: Array<Int> = arrayOf()
    for(carCounter in car.indices){
        for(orderCounter in order.indices){
            val weight = order[orderCounter].weight
            val volume = order[orderCounter].volume
            val passengers = order[orderCounter].numberOfPassengers
            if(orderCounter < order.size && weight != null && passengers != null && volume != null) {
                if (car[carCounter].generalParameters.carBody == order[orderCounter].carType &&
                    car[carCounter].freeLoadCapacity >= weight &&
                    car[carCounter].volume >= volume &&
                    car[carCounter].passengerCapacity >= passengers
                ) {
                    car[carCounter].generalParameters.orderList.add(order[orderCounter])
                    car[carCounter].freeLoadCapacity.minus(weight)
                    car[carCounter].volume.minus(volume)
                    car[carCounter].passengerCapacity.minus(passengers)
                    orderIndex += orderCounter
                }
            }
        }
        if(orderIndex.isNotEmpty()){
            for(indexCounter in orderIndex.indices) {
                order.removeAt(orderIndex.sortedDescending()[indexCounter])
            }
            orderIndex = arrayOf()
        }
    }
}

fun transferOrder(carOrderFrom: Array<PassengerCarModel>, carOrderTo: Array<PassengerCarModel>){
    for(orderFrom in carOrderFrom.indices){
        for(orderTo in carOrderTo.indices){
            if(orderFrom != orderTo && carOrderTo[orderTo].generalParameters.carBody == carOrderFrom[orderFrom].generalParameters.carBody
                && carOrderTo[orderTo].passengerCapacity >= carOrderFrom[orderFrom].passengerCapacity){

            }
        }
    }
}

fun requestOrderInformation(orderList: ArrayList<OrderModel>) {
    for (n in orderList.indices) {
        println(
            "Direction from ${orderList[n].startPoint} to ${orderList[n].endPoint}, " +
                    "weight ${orderList[n].weight}, car type - ${orderList[n].carType}, number of passengers - " +
                    "${orderList[n].numberOfPassengers}, handling operations - ${orderList[n].loadUnloadCargo}"
        )
    }
}