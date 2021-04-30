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

    private val _tvShowData = MutableLiveData<List<TvShowResult>>()
    val tvShowData: LiveData<List<TvShowResult>> get() = _tvShowData

    fun getTvShow(key: String) {
        EspressoIdlingResource.increment()
        viewModelScope.launch {
            try {
                val result = repository.getTvShow(key)
                if (result.isSuccessful && result != null) _tvShowData.postValue(result.body()?.results)
                else Log.d("Request Tv Show", "getTvShow:  ${result.message()}")
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                Log.d("EXCEPTION", "getTvShow result: ${e.message} ")
            } catch (httpException: HttpException) {
                Log.d("HttpException", "getTvShow: result ${httpException.message()}")
            }
        }
    }
}