package com.duzi.paging3example.api

import dagger.Module
import dagger.Provides

@Module(includes = [GithubRemoteDataModule::class])
class GithubRepositoryModule {

    @Provides
    fun provideGithubRemoteDataSource(apiService: GithubService): GithubDataSource {
        return GithubRemoteDataSource(apiService)
    }
}