package taufiq.apps.wathcers.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.adapter.TvShowAdapters
import taufiq.apps.wathcers.adapter.TvShowListener
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.databinding.FragmentFavoriteTvsBinding
import taufiq.apps.wathcers.ui.DetailTvActivity
import taufiq.apps.wathcers.utils.BaseFragment
import taufiq.apps.wathcers.viewmodel.FavoriteViewModel

/**
 * Created By Taufiq on 5/6/2021.
 *
 */
@AndroidEntryPoint
class FavTvShows : BaseFragment(), TvShowListener {

    private lateinit var binding: FragmentFavoriteTvsBinding
    private val tvFavViewmodels by viewModels<FavoriteViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteTvsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvTvFavorite.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = TvShowAdapters(this@FavTvShows)
        }
    }

    override fun observableInit() {
        tvFavViewmodels.getTvFavorite().observe(viewLifecycleOwner) { tvShowEntity ->
            if (tvShowEntity != null) {
                binding.rvTvFavorite.adapter.let {
                    when (it) {
                        is TvShowAdapters -> {
                            it.submitList(tvShowEntity)
                            it.notifyDataSetChanged()
                        }
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