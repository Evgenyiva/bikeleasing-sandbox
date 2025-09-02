package com.bikeleasing.biketrip.model

enum class UserType(val value: String) {
    CUSTOMER("customer"),
    SUBSCRIBER("subscriber"),
    UNKNOWN("");

    companion object {
        fun fromString(value: String): UserType {
            return when (value.lowercase()) {
                CUSTOMER.value -> CUSTOMER
                SUBSCRIBER.value -> SUBSCRIBER
                else -> UNKNOWN
            }
        }
    }
}