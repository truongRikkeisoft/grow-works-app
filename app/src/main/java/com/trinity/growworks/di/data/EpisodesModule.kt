package com.trinity.growworks.di.data

import androidx.compose.runtime.Stable
import com.trinity.growworks.data.database.local.EpisodesLocalDataSource
import com.trinity.growworks.data.database.local.impl.EpisodesLocalDataSourceImpl
import com.trinity.growworks.data.database.remote.api.EpisodesService
import com.trinity.growworks.data.database.remote.source.EpisodesRemoteDataSource
import com.trinity.growworks.data.database.remote.source.impl.EpisodesRemoteDataSourceImpl
import com.trinity.growworks.data.repository.local.EpisodesRealmRepositoryImpl
import com.trinity.growworks.data.repository.remote.EpisodesRepositoryImpl
import com.trinity.growworks.domain.repository.local.EpisodesRealmRepository
import com.trinity.growworks.domain.repository.remote.EpisodesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.realm.kotlin.Realm
import retrofit2.Retrofit

@Stable
@Module
@InstallIn(ViewModelComponent::class)
object EpisodesModule {
    @Provides
    fun provideEpisodesService(retrofit: Retrofit): EpisodesService =
        retrofit.create(EpisodesService::class.java)

    @Provides
    fun provideEpisodesRemoteDataSource(episodesService: EpisodesService): EpisodesRemoteDataSource =
        EpisodesRemoteDataSourceImpl(episodesService)

    @Provides
    fun provideEpisodesRemoteRepository(episodesRemoteDataSource: EpisodesRemoteDataSource): EpisodesRepository =
        EpisodesRepositoryImpl(episodesRemoteDataSource)

    @Provides
    fun providesEpisodesLocalDataSource(realm: Realm): EpisodesLocalDataSource =
        EpisodesLocalDataSourceImpl(realm = realm)

    @Provides
    fun provideEpisodesRepository(episodesLocalDataSource: EpisodesLocalDataSource): EpisodesRealmRepository =
        EpisodesRealmRepositoryImpl(episodesLocalDataSource = episodesLocalDataSource)
}