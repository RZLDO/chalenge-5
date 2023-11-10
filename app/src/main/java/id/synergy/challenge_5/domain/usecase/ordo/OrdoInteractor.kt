package id.synergy.challenge_5.domain.usecase.ordo

import id.synergy.challenge_5.domain.Resource
import id.synergy.challenge_5.domain.model.ordo.OrdoModel
import id.synergy.challenge_5.domain.repository.IOrdoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrdoInteractor @Inject constructor(
    val repository: IOrdoRepository
) : OrdoUseCase{
    override fun getOrdo(): Flow<Resource<List<OrdoModel>>> = repository.getOrdoData()
}