package com.bikeleasing.biketrip.model

import java.time.LocalDateTime

data class Trip(
    val startTime: LocalDateTime,
    val stopTime: LocalDateTime,
    val startStationId: Int,
    val startStationName: String,
    val endStationId: Int,
    val endStationName: String,
    val userType: UserType,
    val bikeId: Long,
    val gender: UserGender,
    val age: Int
)