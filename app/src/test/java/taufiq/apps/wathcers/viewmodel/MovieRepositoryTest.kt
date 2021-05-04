package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import taufiq.apps.wathcers.network.MovieClientRequest
import taufiq.apps.wathcers.utils.LiveDataUtils
import taufiq.apps.wathcers.viewmodel.sample.SampleData
import taufiq.apps.wathcers.viewmodel.sample.SampleMovieRepositoryImpl

/**
 * Created By Taufiq on 5/4/2021.
 *
 */
@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val api = mock(MovieClientRequest::class.java)

    @Mock
    private val repository = SampleMovieRepositoryImpl(api)
    private val movies = SampleData.getSampleOfMovieList()
    private val tvShows = SampleData.getSampleOfTvList()
    private val moviesDetail = SampleData.getSampleOfDetailMovie()
    private val tvShowDetail = SampleData.getSampleOfDetailTvShow()


    @Test
    fun `Verify data movies is not null`() {
        val movieList = MutableLiveData(movies)
        `when`(repository.getPopularMovies()).thenReturn(movieList)
        val moviesData = LiveDataUtils.getValue(repository.getPopularMovies())
        verify(repository).getPopularMovies()
        assertNotNull(moviesData)
        assertEquals(movies.size, moviesData.size)
    }

    @Test
    fun `Verify data tv show is not null`() {
        val tvList = MutableLiveData(tvShows)
        `when`(repository.getTvShow()).thenReturn(tvList)
        val tvData = LiveDataUtils.getValue(repository.getTvShow())
        verify(repository).getTvShow()
        assertNotNull(tvData)
        assertEquals(tvShows.size, tvData.size)
    }


    @Test
    fun `Verifying movie detail is not null`() {
        val movieId = 460465
        val movieDetail = MutableLiveData(moviesDetail)
        `when`(repository.getDetailMovie(movieId)).thenReturn(movieDetail)
        val movieEntities = LiveDataUtils.getValue(repository.getDetailMovie(movieId))
        verify(repository).getDetailMovie(movieId)
        assertNotNull(movieEntities)
        assertEquals(moviesDetail, movieEntities)
        assertEquals(moviesDetail.title, movieEntities.title)
        assertEquals(moviesDetail.releaseDate, movieEntities.releaseDate)
        assertEquals(moviesDetail.overview, movieEntities.overview)
        assertEquals(moviesDetail.genres.toString(), movieEntities.genres.toString())
        assertEquals(moviesDetail.status, movieEntities.status)
        assertEquals(moviesDetail.originalTitle, movieEntities.originalTitle)
        assertEquals(
            moviesDetail.voteAverage.toString(),
            movieEntities.voteAverage.toString()
        )
        assertEquals(moviesDetail.id, movieEntities.id)
        assertEquals(moviesDetail.homepage, movieEntities.homepage)
        assertEquals(moviesDetail.posterPath, movieEntities.posterPath)
        assertEquals(moviesDetail.backdropPath, movieEntities.backdropPath)
    }


    @Test
    fun `verifying tv show data is not equal to null`(){
        val id = 88396
        val tvList = MutableLiveData(tvShowDetail)
        `when`(repository.getDetailTv(id)).thenReturn(tvList)
        val tvData = LiveDataUtils.getValue(repository.getDetailTv(id))
        verify(repository).getDetailTv(id)
        assertNotNull(tvData)
        assertEquals(tvShowDetail.name, tvData.name)
        assertEquals(tvShowDetail.overview, tvData.overview)
        assertEquals(tvShowDetail.backdropPath, tvData.backdropPath)
        assertEquals(tvShowDetail.firstAirDate, tvData.firstAirDate)
        assertEquals(tvShowDetail.genres, tvData.genres)
        assertEquals(tvShowDetail.homepage, tvData.homepage)
        assertEquals(tvShowDetail.id, tvData.id)
        assertEquals(tvShowDetail.lastAirDate, tvData.lastAirDate)
        assertEquals(tvShowDetail.status, tvData.status)
        assertEquals(tvShowDetail.voteAverage, tvData.voteAverage)
        assertEquals(tvShowDetail.posterPath, tvData.posterPath)
    }
}