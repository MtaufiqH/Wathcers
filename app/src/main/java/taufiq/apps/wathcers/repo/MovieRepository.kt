package taufiq.apps.wathcers.repo

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.vo.Resources
import javax.inject.Inject

/**
 * Created By Taufiq on 5/7/2021.
 *
 */
class MovieRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) : DataSource {

    override fun getNowPlayingMovies(): LiveData<Resources<PagedList<MovieEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getListFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> {
        TODO("Not yet implemented")
    }

    override fun getTvShowOnTheAir(): LiveData<Resources<PagedList<TvShowEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getListFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        TODO("Not yet implemented")
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteMovie(movie: MovieEntity) {
        TODO("Not yet implemented")
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity) {
        TODO("Not yet implemented")
    }

}

