package id.synergy.challenge_5.domain.model.ordo

import id.synergy.challenge_5.data.ordo.response.OrdoDataResponse

object OrdoModelMapper {
    fun mapOrdoResponseToDomain(data : List<OrdoDataResponse>) : List<OrdoModel>{
        return data.map { ordo ->
            OrdoModel(
                idOrdo = ordo.idOrdo,
                commonName = ordo.commonName,
                latinName = ordo.latinName,
                image = ordo.image,
                description = ordo.description
            )
        }
    }
}