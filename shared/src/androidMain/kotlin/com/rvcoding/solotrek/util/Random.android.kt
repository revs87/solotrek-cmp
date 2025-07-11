package com.rvcoding.solotrek.util

actual fun randomUUID(): UUID = AndroidUUID(java.util.UUID.randomUUID().toString())

data class AndroidUUID(override val uuid: String) : UUID