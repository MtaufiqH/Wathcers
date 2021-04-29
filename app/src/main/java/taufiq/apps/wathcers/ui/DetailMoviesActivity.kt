package taufiq.apps.wathcers.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import taufiq.apps.wathcers.data.dummy.DataModel
import taufiq.apps.wathcers.databinding.ActivityDetailMoviesBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.MoviesViewModel

class DetailMoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMoviesBinding
    private val viewmodel by viewModels<MoviesViewModel>()
    val movieIntent by lazy {
        intent.getIntExtra(MOVIE_KEY_EXTRA,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


    companion object {
        const val MOVIE_KEY_EXTRA = "MOVIE_KEY_EXTRA"
    }

}