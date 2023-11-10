package id.synergy.challenge_5.domain.repository

import id.synergy.challenge_5.domain.Resource
import id.synergy.challenge_5.domain.model.ordo.OrdoModel
import kotlinx.coroutines.flow.Flow

interface IOrdoRepository {
    fun getOrdoData( ): Flow<Resource<List<OrdoModel>>>
}