package com.tokopedia.searchonboardingtokped.core.di.module

import com.achmadabrar.aruna_test.ui.PostsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): PostsActivity
}