package com.kanneki.opentaipei.ui.main

import androidx.activity.viewModels
import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.base.BaseActivity
import com.kanneki.opentaipei.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun initDataBinding() {
        super.initDataBinding()

        dataBinding.vm = viewModel
    }
}