package com.trinity.growworks.di

import android.content.Context
import androidx.compose.runtime.Stable
import com.trinity.growworks.GrowsWorkApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Stable
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): GrowsWorkApplication = app as GrowsWorkApplication
}