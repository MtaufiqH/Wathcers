package taufiq.apps.wathcers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import javax.inject.Inject

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@HiltViewModel
class TvViewModelDetail @Inject constructor(private val repository: MovieRepositoryImpl) : ViewModel() {

    private val _tvShowDataDetail = MutableLiveData<DetailTvResponse>()
    val tvShowDataDetail : LiveData<DetailTvResponse> get() = _tvShowDataDetail


    fun getTvShowDetail(id: Int, key: String) = viewModelScope.launch {
        try {
            val result = repository.getDetailTv(id,key)
            if (result.isSuccessful && result != null) _tvShowDataDetail.postValue(result.body())
            else Log.d("Request Tv Show", "getTvShow:  ${result.message()}")
        } catch (e: Exception) {
            Log.d("EXCEPTION", "getTvShow result: ${e.message} ")
        } catch (httpException: HttpException) {
            Log.d("HttpException", "getTvShow: result ${httpException.message()}")
        }
    }
}