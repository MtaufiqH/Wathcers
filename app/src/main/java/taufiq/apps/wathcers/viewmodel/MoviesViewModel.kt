package taufiq.apps.wathcers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import taufiq.apps.wathcers.data.DataModel
import taufiq.apps.wathcers.data.DataSourceDummy
import taufiq.apps.wathcers.data.response.movies.MovieResult
import taufiq.apps.wathcers.data.response.movies.tvs.TvShowResult
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MovieRepositoryImpl) :
    ViewModel() {

    private val _movieData = MutableLiveData<List<MovieResult>>()
    val movieData: LiveData<List<MovieResult>> get() = _movieData
    private val _tvShowData = MutableLiveData<List<TvShowResult>>()
    val tvShowData: LiveData<List<TvShowResult>> get() = _tvShowData

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

    fun getTvShow(key: String) = viewModelScope.launch {
        try {
            val result = repository.getTvShow(key)
            if (result.isSuccessful && result != null) _tvShowData.postValue(result.body()?.results) else
                Log.d("Request Tv Show", "getTvShow:  ${result.message()}")
        } catch (e: Exception) {
            Log.d("EXCEPTION", "getTvShow result: ${e.message} ")
        } catch (httpException: HttpException) {
            Log.d("HttpException", "getTvShow: result ${httpException.message()}")
        }
    }

    val allMovies: List<DataModel> = DataSourceDummy.getAllPopularMovies()
    fun getMoviesById(id: Int): DataModel? = DataSourceDummy.getMovie(id)

}