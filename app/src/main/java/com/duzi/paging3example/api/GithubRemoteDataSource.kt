package com.duzi.paging3example.api

import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(private val api: GithubService): GithubDataSource {

    override suspend fun searchRepos(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse {
        return api.searchRepos(query, page, itemsPerPage)
    }

}