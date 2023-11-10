package id.synergy.challenge_5.di.Ordo

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.synergy.challenge_5.data.ordo.OrdoRepository
import id.synergy.challenge_5.domain.repository.IOrdoRepository

@Module(includes = [OrdoNetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class OrdoRepositoryModule {
    @Binds
    abstract fun provideUserRepository(ordoRepository: OrdoRepository) : IOrdoRepository
}



