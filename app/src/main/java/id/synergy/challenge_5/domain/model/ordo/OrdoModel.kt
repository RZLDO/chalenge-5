package id.synergy.challenge_5.domain.model.ordo

import com.google.gson.annotations.SerializedName

data class OrdoModel(
    val idOrdo : Int,
    val latinName : String,
    val commonName : String,
    val description : String,
    val image : String,
)