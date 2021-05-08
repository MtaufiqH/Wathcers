package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.repo.RemoteDataSource
import javax.inject.Inject

@HiltViewModel
class MoviesViewModelDetail @Inject constructor(private val repository: RemoteDataSource) :
    ViewModel() {

    fun getMovieDetail(id: Int) = repository.getDetailMovie(id = id)

}