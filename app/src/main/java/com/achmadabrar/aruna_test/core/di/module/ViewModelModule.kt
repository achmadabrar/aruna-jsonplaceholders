package com.achmadabrar.aruna_test.core.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.achmadabrar.aruna_test.core.di.ViewModelFactory
import com.achmadabrar.aruna_test.core.di.ViewModelKey
import com.achmadabrar.aruna_test.presentation.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    internal abstract fun mainViewModel(viewModel: PostsViewModel): ViewModel

}