package taufiq.apps.wathcers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import taufiq.apps.wathcers.utils.EspressoIdlingResource
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MovieRepositoryImpl) :
    ViewModel() {

    private val _movieData = MutableLiveData<List<MovieResult>>()
    val movieData: LiveData<List<MovieResult>> = _movieData

    fun getMovies(key: String) {
        EspressoIdlingResource.increment()
        viewModelScope.launch {
            try {
                val result = repository.getPopularMovies(key)
                if (result.isSuccessful) {
                    _movieData.postValue(result.body()?.results)
                    Log.d("Request", "getmovies:  ${result.body()?.results?.size}")
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