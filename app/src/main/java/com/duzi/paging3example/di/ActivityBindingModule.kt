package com.duzi.paging3example.di

import com.duzi.paging3example.ui.MainActivity
import com.duzi.paging3example.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            MainActivityModule::class
        ]
    )
    internal abstract fun MainActivity(): MainActivity
}