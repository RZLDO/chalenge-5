package id.synergy.challenge_5.data.ordo.source

import id.synergy.challenge_5.data.ordo.response.OrdosResponse
import retrofit2.http.GET

interface OrdoApiService {
    @GET("ordo")
    suspend fun getOrdo() : OrdosResponse
}