package com.example.muincctv

data class AssistDeviceModel (
    val imgUrl: Int,
    val selectedImgUrl: Int,
    val title: String,
    var isSelected: Boolean = false
)