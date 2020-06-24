package com.duzi.paging3example.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.duzi.paging3example.api.GithubRepository
import com.duzi.paging3example.api.RepoSearchResponse
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: GithubRepository
): ViewModel() {

    var count = 0

    private val _test = MutableLiveData<String>()
    val test: LiveData<String> = _test

    suspend fun searchRepos(
    query: String,
    page: Int,
    itemsPerPage: Int
    ): RepoSearchResponse {
        count += 1
        _test.postValue(count.toString())
        return repository.searchRepos(query, page, itemsPerPage)
    }
}