package com.duzi.paging3example.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.duzi.paging3example.data.GithubPagingSource
import com.duzi.paging3example.model.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultGithubRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource
): GithubRepository {

    override suspend fun getSearchResultStream(query: String): Flow<PagingData<Repo>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { GithubPagingSource(remoteDataSource, query) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}