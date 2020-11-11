package com.achmadabrar.aruna_test.core.di.module

import com.achmadabrar.aruna_test.presentation.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragmentModule(): PostsFragment
}