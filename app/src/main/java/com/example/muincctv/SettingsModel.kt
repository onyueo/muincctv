package com.example.muincctv

import java.time.LocalDate

data class SettingChangeAdminModel (
    val userName: String,
    val userPhoneNumber: String,
)

data class SettingsGroupManageModel(
    val groupName: String,
    val groupAdmin: String,
    val groupDate: String,  // 타입 변경 필요?
)
