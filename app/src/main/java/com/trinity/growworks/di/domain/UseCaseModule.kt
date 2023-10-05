package com.trinity.growworks.di.domain

import com.trinity.growworks.domain.repository.local.EpisodesRealmRepository
import com.trinity.growworks.domain.repository.remote.EpisodesRepository
import com.trinity.growworks.domain.usecase.episodes.GetAllEpisodesRealmUseCase
import com.trinity.growworks.domain.usecase.episodes.GetAllEpisodesUseCase
import com.trinity.growworks.domain.usecase.episodes.SaveEpisodesRealmUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @ViewModelScoped
    @Provides
    fun provideGetAllEpisodesUseCase(
        episodesRepository: EpisodesRepository
    ) = GetAllEpisodesUseCase(repository = episodesRepository)

    @ViewModelScoped
    @Provides
    fun provideSaveEpisodesRealmUseCase(
        episodesRealmRepository: EpisodesRealmRepository
    ) = SaveEpisodesRealmUseCase(repository = episodesRealmRepository)

    @ViewModelScoped
    @Provides
    fun provideGetAllEpisodeRealmUseCase(
        episodesRealmRepository: EpisodesRealmRepository
    ) = GetAllEpisodesRealmUseCase(repository = episodesRealmRepository)
}