package id.synergy.challenge_5.di.Ordo

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.synergy.challenge_5.data.ordo.source.OrdoApiService
import retrofit2.Retrofit
@Module
@InstallIn(SingletonComponent::class)
class OrdoNetworkModule {
    @Provides
    fun provideOrdoApiService(retrofit : Retrofit): OrdoApiService {
        return retrofit.create(OrdoApiService::class.java)
    }
}
