package com.duzi.paging3example.di

import com.duzi.paging3example.base.DefaultDispatcherProvider
import com.duzi.paging3example.base.DispatcherProvider
import dagger.Binds
import dagger.Module

@Module
internal interface AppModule {
    @Binds
    fun bindDispatchers(dispatcher: DefaultDispatcherProvider): DispatcherProvider
}