package com.achmadabrar.aruna_test.core.di.module

import com.achmadabrar.aruna_test.presentation.PostsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): PostsActivity
}