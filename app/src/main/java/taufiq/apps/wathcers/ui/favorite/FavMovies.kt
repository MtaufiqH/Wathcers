package taufiq.apps.wathcers.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.adapter.MovieAdapters
import taufiq.apps.wathcers.adapter.MovieListener
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.databinding.FragmentFavoriteMoviesBinding
import taufiq.apps.wathcers.ui.DetailMoviesActivity
import taufiq.apps.wathcers.utils.BaseFragment
import taufiq.apps.wathcers.viewmodel.FavoriteViewModel

/**
 * Created By Taufiq on 5/6/2021.
 *
 */
@AndroidEntryPoint
class FavMovies : BaseFragment(), MovieListener{

    private lateinit var binding: FragmentFavoriteMoviesBinding
    private val movieFavModels by viewModels<FavoriteViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvMoviesFavorite.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = MovieAdapters(this@FavMovies)
        }
    }

    override fun observableInit() {
        movieFavModels.getMovieFavorite().observe(viewLifecycleOwner) { movieEntity ->
            if (movieEntity != null) {
                binding.rvMoviesFavorite.adapter.let {
                    when(it) {
                        is MovieAdapters -> {
                            it.submitList(movieEntity)
                            it.notifyDataSetChanged()
                        }
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: MovieEntity) {
        startActivity(Intent(context, DetailMoviesActivity::class.java).also {
            it.putExtra(DetailMoviesActivity.MOVIE_KEY_EXTRA,data.movieId)
        })
    }
}