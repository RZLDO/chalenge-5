package id.synergy.challenge_5.data.ordo.response

import com.google.gson.annotations.SerializedName

data class OrdoDataResponse (
    @SerializedName("id_ordo")
    val idOrdo : Int,
    @SerializedName("nama_latin")
    val latinName : String,
    @SerializedName("nama_umum")
    val commonName : String,
    @SerializedName("keterangan")
    val description : String,
    @SerializedName("gambar")
    val image : String,
)