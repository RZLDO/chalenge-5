package id.synergy.challenge_5.data.ordo

import id.synergy.challenge_5.data.ApiResponse
import id.synergy.challenge_5.data.ordo.source.OrdoDataSource
import id.synergy.challenge_5.domain.Resource
import id.synergy.challenge_5.domain.model.ordo.OrdoModel
import id.synergy.challenge_5.domain.model.ordo.OrdoModelMapper
import id.synergy.challenge_5.domain.repository.IOrdoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrdoRepository @Inject constructor(
    private val dataSource: OrdoDataSource
) : IOrdoRepository{
    override fun getOrdoData(): Flow<Resource<List<OrdoModel>>> = flow{
        emit(Resource.Loading())
        when(val result = dataSource.getDataOrdo().first()){
            is ApiResponse.Success -> emit(Resource.Success(OrdoModelMapper.mapOrdoResponseToDomain(result.data.data)))
            is ApiResponse.Error -> {
                emit(Resource.Error(result.errorMessage))
            }
        }
    }
}