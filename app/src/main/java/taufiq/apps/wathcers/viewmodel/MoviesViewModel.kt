package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import taufiq.apps.wathcers.data.DataModel
import taufiq.apps.wathcers.data.DataSourceDummy

class MoviesViewModel : ViewModel() {

    val allMovies : List<DataModel> = DataSourceDummy.getAllPopularMovies()
    fun getMoviesById(id: Int) : DataModel?  =  DataSourceDummy.getMovie(id)

}