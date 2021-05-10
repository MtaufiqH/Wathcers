package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.repo.RemoteDataSource
import taufiq.apps.wathcers.repo.TmdbRepository
import javax.inject.Inject

@HiltViewModel
class MoviesViewModelDetail @Inject constructor(private val repository: TmdbRepository) :
    ViewModel() {

    fun getMovieDetail(id: Int) = repository.getMovieDetail(id)
    fun setMovieFavorite(movieEntity: MovieEntity) = repository.setFavoriteMovie(movieEntity)

}