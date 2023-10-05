package com.trinity.growworks.di.data

import androidx.compose.runtime.Stable
import com.trinity.growworks.data.model.local.Episode
import com.trinity.growworks.data.repository.local.EpisodesRealmRepositoryImpl
import com.trinity.growworks.domain.repository.local.EpisodesRealmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@Stable
@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Episode::class
            )
        )
            .compactOnLaunch()
            .build()

        return Realm.open(config)
    }


}