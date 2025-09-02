package com.bikeleasing.biketrip

import com.bikeleasing.biketrip.datastore.CSVParser
import com.bikeleasing.biketrip.datastore.CSVParserImpl
import com.bikeleasing.biketrip.example.ExampleClass
import com.bikeleasing.biketrip.example.ExampleClassImpl
import java.time.Duration

fun main() {
    val exampleClass: ExampleClass = ExampleClassImpl()
    exampleClass.printExample()

    //val parser: CSVParser = CSVParserImpl()
    //parser.parseCSV()
    //val trips = parser.getTrips()
//
    //trips.take(10).forEach { trip ->
    //    val duration = Duration.between(trip.startTime, trip.stopTime)
    //    println("${trip.endStationName} - ${trip.startStationName}: duration $duration")
    //}
}