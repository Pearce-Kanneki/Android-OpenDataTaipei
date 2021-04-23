package com.kanneki.opentaipei.ui.zoodetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.base.BaseFragment
import com.kanneki.opentaipei.databinding.FragmentZooDetailBinding
import com.kanneki.opentaipei.model.ZooModel
import com.kanneki.opentaipei.ui.plantdetail.PlantDetailFragment
import kotlinx.android.synthetic.main.fragment_zoo_detail.*

class ZooDetailFragment: BaseFragment<ZooDetailViewModel, FragmentZooDetailBinding>() {

    companion object {
        const val BUNDLE_ZOO_CODE = "zoo"
    }

    private val zooDetailAdapter = ZooDetailAdapter{ model, url ->

        model?.let {
            val bundle = Bundle().apply {
                putSerializable(PlantDetailFragment.BUNDLE_PLANT_CODE, it)
            }

            findNavController().navigate(
                    R.id.action_zooDetailFragment_to_plantDetailFragment,
                    bundle
            )
        }?: run {
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(url)
            }
            startActivity(intent)
        }

    }

    override val viewModel: ZooDetailViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.fragment_zoo_detail

    override fun initBindingData() {
        super.initBindingData()

        binding.apply {
            adapter = zooDetailAdapter
            vm = viewModel
        }
    }

    override fun initData() {
        super.initData()

        (arguments?.getSerializable(BUNDLE_ZOO_CODE) as? ZooModel)?.let {

            viewModel.setZooData(it)
            viewModel.searchData(it.eName ?: "")
            zooDetailAdapter.searchHeaderdata(it)
        }
    }

    override fun initView() {
        super.initView()

        viewModel.getErrorMessage.observe(viewLifecycleOwner, { message ->

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })

        zooDetailTool.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}