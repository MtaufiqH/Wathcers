package taufiq.apps.wathcers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import taufiq.apps.wathcers.utils.EspressoIdlingResource
import javax.inject.Inject

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@HiltViewModel
class TvViewModel @Inject constructor(private val repository: MovieRepositoryImpl) : ViewModel() {

    fun getTvShows() = repository.getTvShow()

}