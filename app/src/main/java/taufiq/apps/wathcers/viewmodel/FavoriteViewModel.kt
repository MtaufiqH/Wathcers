package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.repo.TmdbRepository
import javax.inject.Inject

/**
 * Created By Taufiq on 5/10/2021.
 *
 */
@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: TmdbRepository) : ViewModel(){

    fun getMovieFavorite() = repository.getListFavoriteMovies()
    fun getTvFavorite() = repository.getListFavoriteTvShows()

}