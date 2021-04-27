package taufiq.apps.wathcers.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.adapter.TvShowAdapter
import taufiq.apps.wathcers.databinding.FragmentTvBinding
import taufiq.apps.wathcers.utils.BaseFragment
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.TvViewModel

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@AndroidEntryPoint
class TvFragment : BaseFragment() {
    lateinit var binding: FragmentTvBinding
    private val viewModel by viewModels<TvViewModel>()
    private val adapter by lazy {
        TvShowAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvTvShow.adapter = adapter
        binding.rvTvShow.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter.itemClickListener = {
            startActivity(Intent(requireContext(), DetailMoviesActivity::class.java).also {
                // TODO: add PutExtra to the
            })
        }
    }

    override fun observableInit() {
        viewModel.getTvShow(Constant.TMBD_API_KEY)
        viewModel.tvShowData.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) adapter.setData(it)
        }
    }


}