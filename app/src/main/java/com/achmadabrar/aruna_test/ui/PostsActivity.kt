package com.achmadabrar.aruna_test.ui

import android.os.Bundle
import com.achmadabrar.aruna_test.R
import com.tokopedia.searchonboardingtokped.core.base.BaseActivity

class PostsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, PostsFragment()).commit()
    }
}