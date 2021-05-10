package taufiq.apps.wathcers.ui

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.RoundedCornersTransformation
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.databinding.ActivityDetailMoviesBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.MoviesViewModelDetail

@AndroidEntryPoint
class DetailMoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMoviesBinding
    private val movieViewModel by viewModels<MoviesViewModelDetail>()
    private val idMovie by lazy {
        intent.getIntExtra(MOVIE_KEY_EXTRA, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeMovieDetail(idMovie)


    }

    private fun observeMovieDetail(id: Int) {
        movieViewModel.getMovieDetail(id).observe(this) { movies ->
            with(binding) {
                ivBackdrop.load(Constant.IMAGE_PATH + movies.backdrop)
                moviePoster.load(Constant.IMAGE_PATH + movies.poster) {
                    transformations(RoundedCornersTransformation(16f))
                }
                val isFavorite = movies.isFavorite
                tvMovieTitle.text = movies.movieName
                movieRating.rating = movies.ratings!!.toFloat()
                tvMovieOverview.text = movies.movieDesc
                tvDate.text = movies.dates

                favoriteMovie.setOnClickListener {
                    setFavorite(movies)
                }

                setFavoriteState(isFavorite)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setFavoriteState(status: Boolean) {
        if (status) {
            binding.favoriteMovie.setImageResource(R.drawable.ic_favorite)
        } else {
            binding.favoriteMovie.setImageResource(R.drawable.ic_unfavorite)
        }
    }

    private fun setFavorite(movies: MovieEntity) {
        if (movies.isFavorite) {
            Toast.makeText(this, "set as favorite", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "remove from favorite", Toast.LENGTH_SHORT).show()
        }

        movieViewModel.setMovieFavorite(movies)
    }

    companion object {
        const val MOVIE_KEY_EXTRA = "MOVIE_KEY_EXTRA"
    }

}