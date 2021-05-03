package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class MoviesViewModelDetail @Inject constructor(private val repository: MovieRepositoryImpl) :
    ViewModel() {

    fun getMovieDetail(id: Int) = repository.getDetailMovie(id = id)

}