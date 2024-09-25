package com.example.muincctv

data class MainMenuModel (
    val menu_text: String,
    val menu_img: Int,
    val is_admin: Boolean,
    var is_opened: Boolean = false
)