package id.synergy.challenge_5.data.ordo.response

import com.google.gson.annotations.SerializedName

data class OrdosResponse (
    @SerializedName("error")
    val error : Boolean,
    @SerializedName("message")
    val message : String,
    @SerializedName("data")
    val data : List<OrdoDataResponse>
)