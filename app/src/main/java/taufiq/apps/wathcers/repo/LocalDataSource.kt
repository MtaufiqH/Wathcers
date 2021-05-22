package taufiq.apps.wathcers.repo

import androidx.lifecycle.LiveData
import taufiq.apps.wathcers.data.db.TmdbDao
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import javax.inject.Inject
import androidx.paging.DataSource

/**
 * Created By Taufiq on 5/7/2021.
 *
 */
class LocalDataSource @Inject constructor(private val dao : TmdbDao) {

    fun getListMovies() : DataSource.Factory<Int, MovieEntity> = dao.getListMovies()

    fun getListFavoriteMovies() : DataSource.Factory<Int, MovieEntity> = dao.getListFavoriteMovies()

    fun getListTvShows() : DataSource.Factory<Int, TvShowEntity> = dao.getListTvShows()

    fun getListFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity> = dao.getListFavoriteTvShows()

    fun getDetailMovie(movieId: Int) : LiveData<MovieEntity> = dao.getDetailMovieById(movieId)

    fun getDetailTvShow(tvShowId: Int) : LiveData<TvShowEntity> = dao.getDetailTvShowById(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = dao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = dao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie : MovieEntity) {
        movie.isFavorite = !movie.isFavorite
        dao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow : TvShowEntity) {
        tvShow.isFavorite = !tvShow.isFavorite
        dao.updateTvShow(tvShow)
    }
}