package com.duzi.paging3example.api

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module(includes = [
    GithubRepositoryModuleBinds::class,
    GithubRemoteDataModule::class
])
@InstallIn(ApplicationComponent::class)
class GithubRepositoryModule {

    @Provides
    fun provideGithubRemoteDataSource(apiService: GithubService): GithubDataSource {
        return GithubRemoteDataSource(apiService)
    }
}


@Module
@InstallIn(ApplicationComponent::class)
abstract class GithubRepositoryModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: DefaultGithubRepository): GithubRepository
}