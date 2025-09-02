package com.bikeleasing.biketrip.datastore

import com.bikeleasing.biketrip.model.Trip

interface CSVParser {
    fun parseCSV()
    fun getTrips(): List<Trip>
}