package com.daggerhilt.valorantapi.di

import com.daggerhilt.valorantapi.data.remote.ValorantApiService
import com.daggerhilt.valorantapi.data.repository.AgentRepositoryImpl
import com.daggerhilt.valorantapi.domain.repository.AgentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://valorant-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideValorantApiService(retrofit: Retrofit): ValorantApiService {
        return retrofit.create(ValorantApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAgentRepository(apiService: ValorantApiService): AgentRepository {
        return AgentRepositoryImpl(apiService)
    }
}
