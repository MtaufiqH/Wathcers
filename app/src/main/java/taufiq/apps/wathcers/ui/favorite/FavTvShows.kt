package taufiq.apps.wathcers.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import taufiq.apps.wathcers.databinding.FragmentFavoriteMoviesBinding
import taufiq.apps.wathcers.databinding.FragmentFavoriteTvsBinding
import taufiq.apps.wathcers.utils.BaseFragment

/**
 * Created By Taufiq on 5/6/2021.
 *
 */
class FavTvShows : BaseFragment() {

    private lateinit var binding: FragmentFavoriteTvsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteTvsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.btnFavTv.setOnClickListener {
            Toast.makeText(requireContext(), "Favorite tv", Toast.LENGTH_SHORT).show()
        }
    }

    override fun observableInit() {

    }
}