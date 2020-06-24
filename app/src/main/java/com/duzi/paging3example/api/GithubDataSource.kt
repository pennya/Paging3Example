package com.duzi.paging3example.api

interface GithubDataSource {

    suspend fun searchRepos(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse
}