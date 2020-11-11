package com.tokopedia.searchonboardingtokped.core.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.achmadabrar.aruna_test.ui.PostsViewModel
import com.tokopedia.searchonboardingtokped.core.di.ViewModelFactory
import com.tokopedia.searchonboardingtokped.core.di.ViewModelKey
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