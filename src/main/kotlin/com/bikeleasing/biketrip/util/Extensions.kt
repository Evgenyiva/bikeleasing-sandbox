package com.bikeleasing.biketrip.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toSafeInt(): Int {
    return this.toIntOrNull() ?: -1
}

fun String.toSafeLong(): Long {
    return this.toLongOrNull() ?: -1L
}

fun String.toLocalDateTime(): LocalDateTime {
    return try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        LocalDateTime.parse(this, formatter)
    } catch (e: Exception) {
        LocalDateTime.MIN
    }
}

fun String.unquote(): String {
    return this.trim('\"').removeSurrounding("\"")
}