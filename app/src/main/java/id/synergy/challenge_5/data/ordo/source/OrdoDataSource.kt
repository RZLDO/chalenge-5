package id.synergy.challenge_5.data.ordo.source

import id.synergy.challenge_5.data.ApiResponse
import id.synergy.challenge_5.data.ordo.response.OrdosResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrdoDataSource @Inject constructor(
    val apiService : OrdoApiService
){
    fun getDataOrdo() : Flow<ApiResponse<OrdosResponse>>  = flow {
        val result = try{
            val response = apiService.getOrdo()
            ApiResponse.Success(response)
        }catch (e : Exception){
            ApiResponse.Error(e.message.toString())
        }
        emit(result)
    }
}