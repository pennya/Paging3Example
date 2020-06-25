package com.duzi.paging3example.api

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    GithubRepositoryModuleBinds::class,
    GithubRemoteDataModule::class
])
class GithubRepositoryModule {

    @Provides
    fun provideGithubRemoteDataSource(apiService: GithubService): GithubDataSource {
        return GithubRemoteDataSource(apiService)
    }
}


@Module
abstract class GithubRepositoryModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: DefaultGithubRepository): GithubRepository
}