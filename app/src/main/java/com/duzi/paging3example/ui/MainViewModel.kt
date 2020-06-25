package com.duzi.paging3example.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.duzi.paging3example.api.GithubRepository
import com.duzi.paging3example.base.BaseViewModel
import com.duzi.paging3example.base.DispatcherProvider
import com.duzi.paging3example.model.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val repository: GithubRepository
): BaseViewModel() {

    private var currentQueryValue: String? = null

    private var currentSearchResult: Flow<PagingData<Repo>>? = null

    suspend fun searchRepos(queryString: String): Flow<PagingData<Repo>> {
        val lastResult = currentSearchResult
        if (queryString == currentQueryValue && lastResult != null) {
            return lastResult
        }
        currentQueryValue = queryString
        val newResult: Flow<PagingData<Repo>> = repository.getSearchResultStream(queryString)
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}