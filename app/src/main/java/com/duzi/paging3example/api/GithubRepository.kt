package com.duzi.paging3example.api

import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource
): GithubDataSource {

    override suspend fun searchRepos(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse {
        return remoteDataSource.searchRepos(query, page, itemsPerPage)
    }

}