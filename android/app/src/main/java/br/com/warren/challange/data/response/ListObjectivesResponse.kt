package br.com.warren.challange.data.response

import com.google.gson.annotations.SerializedName

data class ListObjectivesResponse(
    @SerializedName("portfolios")
    val portfolios: List<ObjectiveResponse>
)
