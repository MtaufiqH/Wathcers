package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MovieRepositoryImpl) :
    ViewModel() {

    fun getMovies() = repository.getPopularMovies()
}