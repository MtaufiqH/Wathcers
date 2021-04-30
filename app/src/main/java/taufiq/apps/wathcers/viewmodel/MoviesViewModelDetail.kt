package taufiq.apps.wathcers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import taufiq.apps.wathcers.utils.EspressoIdlingResource
import javax.inject.Inject

@HiltViewModel
class MoviesViewModelDetail @Inject constructor(private val repository: MovieRepositoryImpl) :
    ViewModel() {

    private val _movieDetailData = MutableLiveData<DetailMovieResponse>()
    val movieDetailData: LiveData<DetailMovieResponse> = _movieDetailData

    fun getMovieDetail(id: Int, key: String) {
        EspressoIdlingResource.increment()
        viewModelScope.launch {
            try {
                val result = repository.getDetailMovie(id, key)
                if (result.isSuccessful) {
                    _movieDetailData.postValue(result.body())
                    Log.d("Request", "getmovies:  ${result.body()}")
                    EspressoIdlingResource.decrement()
                } else Log.d("Request movies", "getmovies:  ${result.message()}")
            } catch (e: Exception) {
                Log.d("EXCEPTION", "getMovies result: ${e.message} ")
            } catch (httpException: HttpException) {
                Log.d("HttpException", "getMovies: result ${httpException.message()}")
            }

        }

    }

}