package id.synergy.challenge_5.domain.usecase.ordo

import id.synergy.challenge_5.domain.Resource
import id.synergy.challenge_5.domain.model.ordo.OrdoModel
import kotlinx.coroutines.flow.Flow

interface OrdoUseCase {
    fun getOrdo() : Flow<Resource<List<OrdoModel>>>
}