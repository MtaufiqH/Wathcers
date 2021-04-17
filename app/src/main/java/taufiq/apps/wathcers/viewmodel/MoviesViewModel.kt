package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import taufiq.apps.wathcers.data.DataModel
import taufiq.apps.wathcers.data.DataSourceDummy

class MoviesViewModel : ViewModel() {

    val allMovies: List<DataModel> = DataSourceDummy.getAllPopularMovies()
    fun getMoviesById(id: Int): DataModel? = DataSourceDummy.getMovie(id)

}