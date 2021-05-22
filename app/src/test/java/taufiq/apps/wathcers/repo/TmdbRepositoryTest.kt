package taufiq.apps.wathcers.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.utils.LiveDataUtils
import taufiq.apps.wathcers.viewmodel.sample.PageListUtil
import taufiq.apps.wathcers.viewmodel.sample.SampleData
import taufiq.apps.wathcers.viewmodel.sample.TmdbRepositoryFake
import taufiq.apps.wathcers.vo.Resources

/**
 * Created By Taufiq on 5/11/2021.
 */
class TmdbRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dataRemote = mock(RemoteDataSource::class.java)
    private val localData = mock(LocalDataSource::class.java)
    private val tmdbRepository = TmdbRepositoryFake(dataRemote, localData)

    private val listMovie = SampleData.getSampleOfMovieList()
    private val listTvShow = SampleData.getSampleOfTvList()
    private val movie = SampleData.getSampleOfMovieList()[0]
    private val tvShow = SampleData.getSampleOfTvList()[0]

    @Test
    fun getPopularMovies() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(localData.getListMovies()).thenReturn(dataSource)
        tmdbRepository.getPopularMovies()
        val movie = Resources.success(PageListUtil.mockPagedList(SampleData.getSampleOfMovieList()))
        verify(localData).getListMovies()
        assertNotNull(movie.data)
        assertEquals(listMovie.size.toLong(), movie.data?.size?.toLong())
    }

    @Test
    fun getPopularTvShows() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(localData.getListTvShows()).thenReturn(dataSource)
        tmdbRepository.getTvShow()
        val tvShow = Resources.success(PageListUtil.mockPagedList(SampleData.getSampleOfTvList()))
        verify(localData).getListTvShows()
        assertNotNull(tvShow.data)
        assertEquals(listTvShow.size.toLong(), tvShow.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail(){
        val sampleMovie = MutableLiveData<MovieEntity>()
        sampleMovie.value = movie
        `when`(localData.getDetailMovie(movie.movieId)).thenReturn(sampleMovie)

        val data = LiveDataUtils.getValue(tmdbRepository.getMovieDetail(movie.movieId))
        verify(localData).getDetailMovie(movie.movieId)
        assertNotNull(data)
        assertEquals(movie.movieId, data.movieId)
    }

    @Test
    fun getTvDetail(){
        val sampleTv = MutableLiveData<TvShowEntity>()
        sampleTv.value = tvShow
        `when`(localData.getDetailTvShow(tvShow.tvId)).thenReturn(sampleTv)

        val data = LiveDataUtils.getValue(tmdbRepository.getTvShowDetail(tvShow.tvId))
        verify(localData).getDetailTvShow(tvShow.tvId)
        assertNotNull(data)
        assertEquals(tvShow.tvId, data.tvId)
    }


    @Test
    fun getListFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(localData.getListFavoriteMovies()).thenReturn(dataSourceFactory)
        tmdbRepository.getListFavoriteMovies()

        val movieEntity = Resources.success(PageListUtil.mockPagedList(SampleData.getSampleOfMovieList()))
        verify(localData).getListFavoriteMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getListFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(localData.getListFavoriteTvShows()).thenReturn(dataSourceFactory)
        tmdbRepository.getListFavoriteTvShows()

        val tvShowEntity = Resources.success(PageListUtil.mockPagedList(SampleData.getSampleOfTvList()))
        verify(localData).getListFavoriteTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun updateFavoriteMovie(){
        doNothing().`when`(localData).setFavoriteMovie(movie)
        tmdbRepository.setFavoriteMovie(movie)
        verify(localData, times(1)).setFavoriteMovie(movie)
    }

    @Test
    fun updateFavoriteTvShow(){
        doNothing().`when`(localData).setFavoriteTvShow(tvShow)
        tmdbRepository.setFavoriteTvShow(tvShow)
        verify(localData, times(1)).setFavoriteTvShow(tvShow)
    }


}