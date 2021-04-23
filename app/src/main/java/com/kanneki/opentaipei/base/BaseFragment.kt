package com.kanneki.opentaipei.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VT: ViewModel, VB: ViewDataBinding>: Fragment() {

    abstract val viewModel: VT

    lateinit var binding: VB

    @LayoutRes
    abstract fun getLayoutRes(): Int

    open fun initBindingData(){}

    open fun initData(){}

    open fun initView(){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            getLayoutRes(),
            container,
            false
        )

        initBindingData()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initView()
    }
}