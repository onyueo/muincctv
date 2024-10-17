package com.example.muincctv

data class MainSettingModel (
    val title: String,
    val destination: Class<*>
)

data class EntryRecordsDropdownModel (
    val title: String,
)

data class EmergencyContactModel(
    val name: String,
    val phone: String
)
