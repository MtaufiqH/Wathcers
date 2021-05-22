package taufiq.apps.wathcers.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.adapter.TvShowAdapters
import taufiq.apps.wathcers.adapter.TvShowListener
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.databinding.FragmentTvBinding
import taufiq.apps.wathcers.utils.BaseFragment
import taufiq.apps.wathcers.viewmodel.TvViewModel
import taufiq.apps.wathcers.vo.Status

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@AndroidEntryPoint
class TvFragment : BaseFragment(), TvShowListener {
    private lateinit var binding: FragmentTvBinding
    private val viewModel by viewModels<TvViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvTvShow.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = TvShowAdapters(this@TvFragment)
        }

    }

    override fun observableInit() {
        viewModel.getTvShows().observe(viewLifecycleOwner) { tvDatas ->
            if (tvDatas != null) {
                when (tvDatas.status) {
                    Status.LOADING -> {
                        binding.pbTvshow.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.pbTvshow.visibility = View.GONE
                        binding.rvTvShow.adapter?.let {
                            when (it) {
                                is TvShowAdapters -> {
                                    it.submitList(tvDatas.data)
                                    it.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding.pbTvshow.visibility = View.GONE
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.check_internet),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: TvShowEntity) {
        startActivity(Intent(requireContext(), DetailTvActivity::class.java).also {
            it.putExtra(DetailTvActivity.TV_KEY_EXTRA, data.tvId)
        })
    }
}
