package com.example.carpark.model

data class CargoPassengerModel(
    val generalParameters: GeneralCarParameterModel,
    val freeLoadCapacity: Double,
    val volume: Double,
    val passengerCapacity: Int
    )
