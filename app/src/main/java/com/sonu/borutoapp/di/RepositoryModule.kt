package com.sonu.borutoapp.di

import android.content.Context
import com.sonu.borutoapp.data.repository.DataStoreOperationsImpl
import com.sonu.borutoapp.data.repository.Repository
import com.sonu.borutoapp.domain.repository.DataStoreOperations
import com.sonu.borutoapp.domain.use_cases.UseCases
import com.sonu.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.sonu.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUsesCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }
}