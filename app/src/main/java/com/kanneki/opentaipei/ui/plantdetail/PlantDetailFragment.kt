package com.kanneki.opentaipei.ui.plantdetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.base.BaseFragment
import com.kanneki.opentaipei.databinding.FragmentPlantDetailBinding
import com.kanneki.opentaipei.model.PlantModel
import kotlinx.android.synthetic.main.fragment_plant_detail.*

class PlantDetailFragment: BaseFragment<PlantDetailViewModel, FragmentPlantDetailBinding>() {

    companion object{
        const val BUNDLE_PLANT_CODE = "plant"
    }

    private val plantDetailAdapter = PlantDetailAdapter()

    override val viewModel: PlantDetailViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.fragment_plant_detail

    override fun initBindingData() {
        super.initBindingData()

        binding.apply {
            adapter = plantDetailAdapter
            vm = viewModel
        }
    }

    override fun initData() {
        super.initData()

        (arguments?.getSerializable(BUNDLE_PLANT_CODE) as? PlantModel)?.let {

            viewModel.setImageUrl(it.fPic01URL ?: "")
            viewModel.setToolBarText(it.fNameCh ?: "")
            viewModel.setData(
                    it,
                    resources.getStringArray(R.array.showTextList).toList()
            )
        }

        plantDetailAdapter.searchTitleImager(viewModel.imageUrl.get() ?: "")
    }

    override fun initView() {
        super.initView()

        plantToolbar.setNavigationOnClickListener {

            findNavController().popBackStack()
        }
    }
}