package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.repo.TmdbRepository
import javax.inject.Inject

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@HiltViewModel
class TvViewModelDetail @Inject constructor(private val repository: TmdbRepository) :
    ViewModel() {

    fun getTvShowDetail(id: Int) = repository.getTvShowDetail(id)
    fun setFavoritTvShow(tvShowEntity: TvShowEntity) = repository.setFavoriteTvShow(tvShowEntity)
}