package id.synergy.challenge_5.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.synergy.challenge_5.domain.usecase.ordo.OrdoInteractor
import id.synergy.challenge_5.domain.usecase.ordo.OrdoUseCase
import id.synergy.challenge_5.ui.MainViewModel

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideOrdo(ordoInteractor: OrdoInteractor) : OrdoUseCase
}

