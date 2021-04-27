package taufiq.apps.wathcers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import taufiq.apps.wathcers.data.response.movies.MovieResult
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MovieRepositoryImpl) :
    ViewModel() {

    private val _movieData = MutableLiveData<List<MovieResult>>()
    val movieData: LiveData<List<MovieResult>> get() = _movieData

    fun getMovies(key: String) = viewModelScope.launch {
        try {
            val result = repository.getPopularMovies(key)
            if (result.isSuccessful && result != null) _movieData.postValue(result.body()?.results) else
                Log.d("Request Tv Show", "getTvShow:  ${result.message()}")
        } catch (e: Exception) {
            Log.d("EXCEPTION", "getMovies result: ${e.message} ")
        } catch (httpException: HttpException) {
            Log.d("HttpException", "getMovies: result ${httpException.message()}")
        }


    }

}