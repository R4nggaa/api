package com.example.api.Model

data class MedicalRecord(var title: String, var image: String)
data class BaseMedicalRecord(var code: Int, var status: String, var data: List<MedicalRecord>)

