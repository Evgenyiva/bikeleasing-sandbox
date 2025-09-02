package com.bikeleasing.biketrip.datastore

import com.bikeleasing.biketrip.model.Trip
import com.bikeleasing.biketrip.model.UserGender
import com.bikeleasing.biketrip.model.UserType
import com.bikeleasing.biketrip.util.toLocalDateTime
import com.bikeleasing.biketrip.util.toSafeInt
import com.bikeleasing.biketrip.util.toSafeLong
import com.bikeleasing.biketrip.util.unquote

class CSVParserImpl : CSVParser {
    private var trips: MutableList<Trip> = mutableListOf()

    override fun parseCSV() {
        this::class.java.classLoader.getResourceAsStream("trips.csv").use { inputStream ->
            inputStream?.bufferedReader()?.useLines { lines ->
                lines.drop(1).forEach { line ->
                    if (line.isNotBlank()) {
                        val trip = convertToTrips(line)
                        trips.add(trip)
                    }
                }
            } ?: throw IllegalArgumentException("File not found or empty")
        }
    }

    private fun convertToTrips(line: String): Trip {
        val parts = line.split(",").map { it.unquote() }

        return Trip(
            startTime = parts[0].toLocalDateTime(),
            stopTime = parts[1].toLocalDateTime(),
            startStationId = parts[2].toSafeInt(),
            startStationName = parts[3],
            endStationId = parts[4].toSafeInt(),
            endStationName = parts[5],
            userType = UserType.fromString(parts[6]),
            bikeId = parts[7].toSafeLong(),
            gender = UserGender.fromString(parts[8]),
            age = parts[9].toSafeInt()
        )
    }

    override fun getTrips(): List<Trip> {
        return trips
    }
}