package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.repo.TmdbRepository
import javax.inject.Inject

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@HiltViewModel
class TvViewModel @Inject constructor(private val repository: TmdbRepository) : ViewModel() {

    fun getTvShows() = repository.getTvShow()

}