package br.com.warren.challange.data.response

import com.google.gson.annotations.SerializedName

data class ObjectiveResponse(
    @SerializedName("_id")
    val id: String,
    val name: String,
    val totalBalance: Double,
    val goalAmount: Double?,
    var goalDate: String,
    var background: BackgroundResponse

) {
    data class BackgroundResponse(
        val thumb: String,
        val small: String,
        val full: String,
        val regular: String,
        val raw: String,
    )
}
