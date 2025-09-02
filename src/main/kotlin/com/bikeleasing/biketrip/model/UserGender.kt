package com.bikeleasing.biketrip.model

enum class UserGender(val value: String) {
    MALE("fale"),
    FEMALE("female"),
    DIVERSE("diverse"),
    UNKNOWN("");

    companion object {
        fun fromString(value: String): UserGender {
            return when (value.lowercase()) {
                MALE.value -> MALE
                FEMALE.value -> FEMALE
                DIVERSE.value -> DIVERSE
                else -> UNKNOWN
            }
        }
    }
}