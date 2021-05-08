package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import taufiq.apps.wathcers.repo.RemoteDataSource
import javax.inject.Inject

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@HiltViewModel
class TvViewModelDetail @Inject constructor(private val repository: RemoteDataSource) :
    ViewModel() {

    fun getTvShowDetail(id: Int) = repository.getDetailTv(id = id)
}