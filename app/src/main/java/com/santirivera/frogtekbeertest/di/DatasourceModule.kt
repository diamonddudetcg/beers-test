package com.santirivera.frogtekbeertest.di

import android.content.Context
import android.content.res.AssetManager
import com.santirivera.data.api.BeersApi
import com.santirivera.data.api.BeersDataSource
import com.santirivera.data.api.BeersDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatasourceModule {

    @Provides
    @Singleton
    fun providesAssetManager(@ApplicationContext context: Context): AssetManager {
        return context.assets
    }

    @Provides
    @Singleton
    fun providesBeersDataSource(beersApi: BeersApi): BeersDataSource = BeersDataSourceImpl(beersApi)

}