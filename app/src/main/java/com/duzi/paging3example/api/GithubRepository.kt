package com.duzi.paging3example.api

import androidx.paging.PagingData
import com.duzi.paging3example.model.Repo
import kotlinx.coroutines.flow.Flow

interface GithubRepository {

    fun getSearchResultStream(query: String): Flow<PagingData<Repo>>

}