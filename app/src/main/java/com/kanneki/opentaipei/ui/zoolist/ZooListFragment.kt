package com.kanneki.opentaipei.ui.zoolist

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.base.BaseFragment
import com.kanneki.opentaipei.databinding.FragmentZoolistBinding
import com.kanneki.opentaipei.ui.zoodetail.ZooDetailFragment

class ZooListFragment: BaseFragment<ZooListViewModel, FragmentZoolistBinding>() {


    private val zooListAdapter = ZooListAdapter{

        val bundle = Bundle().apply {
            putSerializable(ZooDetailFragment.BUNDLE_ZOO_CODE, it)
        }

        findNavController().navigate(R.id.action_zooListFragment_to_zooDetailFragment, bundle)
    }

    override val viewModel: ZooListViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.fragment_zoolist

    override fun initBindingData() {
        super.initBindingData()

        binding.apply {
            adapter = zooListAdapter
            vm = viewModel
        }
    }

    override fun initData() {
        super.initData()

        viewModel.searchData()
    }

    override fun initView() {
        super.initView()

        viewModel.getErrorMessage.observe(viewLifecycleOwner, { message ->

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })
    }
}