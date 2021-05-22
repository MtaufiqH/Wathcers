package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.repo.TmdbRepository
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: TmdbRepository) :
    ViewModel() {

    fun getMovies() = repository.getPopularMovies()
}