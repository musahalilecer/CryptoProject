package com.musahalilecer.cryptoproject.model

import com.google.gson.annotations.SerializedName


data class CryptoModel(
    @SerializedName("currency") // yazma zorunlu değil
    val currency: String,
    @SerializedName("price")
    val price: String) {
}