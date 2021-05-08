package taufiq.apps.wathcers.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.RoundedCornersTransformation
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
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
                ivBackdrop.load(Constant.IMAGE_PATH + movies.backdropPath)
                moviePoster.load(Constant.IMAGE_PATH + movies.posterPath) {
                    transformations(RoundedCornersTransformation(16f))
                }

                tvMovieTitle.text = movies.title
                val allGenres = movies.genres.map {
                    it.name
                }
                movieGenre.text = allGenres.joinToString()
                movieRating.rating = movies.voteAverage.toFloat()
                tvMovieOverview.text = movies.overview
                tvDate.text = movies.releaseDate
                tvReleasedStatus.text = movies.status
                btnMore.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movies.homepage))
                    startActivity(intent)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.fav_button_menu) {

        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val MOVIE_KEY_EXTRA = "MOVIE_KEY_EXTRA"
    }

}