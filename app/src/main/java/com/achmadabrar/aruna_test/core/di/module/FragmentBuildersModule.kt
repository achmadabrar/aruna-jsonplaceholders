package com.tokopedia.searchonboardingtokped.core.di.module

import com.achmadabrar.aruna_test.ui.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragmentModule(): PostsFragment
}