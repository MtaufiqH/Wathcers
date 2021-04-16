package taufiq.apps.wathcers.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import taufiq.apps.wathcers.data.DataModel
import taufiq.apps.wathcers.databinding.ActivityDetailMoviesBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.MoviesViewModel

class DetailMoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMoviesBinding
    private val viewmodel by viewModels<MoviesViewModel>()

    private val movieId by lazy {
        intent.getIntExtra(Constant.KEY_MOVIE, 0)
    }
    private val tvId by lazy {
        intent.getIntExtra(Constant.KEY_TVSHOW, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel.getMoviesById(movieId)?.let { bindData(it) }
    }

    private fun bindData(data: DataModel) {
        binding.apply {
            ivPosterDetail.load(data.image)
            tvMovieTitle.text = data.title
            tvMovieOverview.text = data.description
            tvYear.text = data.date
            btnBook.setOnClickListener {
                Toast.makeText(
                    this@DetailMoviesActivity,
                    "Thank your for booking",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}