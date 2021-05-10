package taufiq.apps.wathcers.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.RoundedCornersTransformation
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.databinding.ActivityDetailTvBinding
import taufiq.apps.wathcers.utils.Constant.Companion.IMAGE_PATH
import taufiq.apps.wathcers.viewmodel.TvViewModelDetail

@AndroidEntryPoint
class DetailTvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvBinding
    private val tvViewModel by viewModels<TvViewModelDetail>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idTv = intent.getIntExtra(TV_KEY_EXTRA, 0)

        observeDataTv(idTv)

    }

    private fun setFavoriteState(status: Boolean) {
        if (status) {
            binding.favoriteTv.setImageResource(R.drawable.ic_favorite)
        } else {
            binding.favoriteTv.setImageResource(R.drawable.ic_unfavorite)
        }
    }

    private fun setFavorite(tvShows: TvShowEntity) {
        if (tvShows.isFavorite) {
            Toast.makeText(this, "set as favorite", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "remove from favorite", Toast.LENGTH_SHORT).show()
        }

        tvViewModel.setFavoritTvShow(tvShows)
    }

    private fun observeDataTv(id: Int) {
        tvViewModel.getTvShowDetail(id).observe(this) { tv ->
            binding.apply {
                ivBackdropTv.load(IMAGE_PATH + tv.backdrop)
                moviePosterTv.load(IMAGE_PATH + tv.poster) {
                    transformations(RoundedCornersTransformation(16f))
                }
                tvMovieTitleTv.text = tv.tvName
                val isFavorite = tv.isFavorite
                movieRatingTv.rating = tv.ratings!!.toFloat()
                tvMovieOverviewTv.text = tv.desc
                tvDateTv.text = tv.dates

                binding.favoriteTv.setOnClickListener {
                    setFavorite(tv)
                }

                setFavoriteState(isFavorite)
            }
        }

    }


    companion object {
        const val TV_KEY_EXTRA = "TV_KEY_EXTRA"
    }
}