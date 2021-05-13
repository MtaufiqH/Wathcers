package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.repo.TmdbRepository
import taufiq.apps.wathcers.viewmodel.sample.SampleData

/**
 * Created By Taufiq on 5/3/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MoviesViewModelDetail

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    private val movieSample = SampleData.getSampleOfMovieList()[0]
    private val movieId = movieSample.movieId

    @Before
    fun setUp() {
        movieViewModel = MoviesViewModelDetail(tmdbRepository)
    }

    @Test
    fun `verify detail movie popular`() {
        val sampleMovie = MutableLiveData<MovieEntity>()
        sampleMovie.value = movieSample
        `when`(tmdbRepository.getMovieDetail(movieId)).thenReturn(sampleMovie)
        val movie = movieViewModel.getMovieDetail(movieId).value
        assertNotNull(movie)
        assertEquals(movieSample.id, movie?.id)
        assertEquals(movieSample.movieId, movie?.movieId)
        assertEquals(movieSample.poster, movie?.poster)
        assertEquals(movieSample.backdrop, movie?.backdrop)
        assertEquals(movieSample.dates, movie?.dates)
        assertEquals(movieSample.isFavorite, movie?.isFavorite)
        assertEquals(movieSample.movieDesc, movie?.movieDesc)
        assertEquals(movieSample.ratings, movie?.ratings)
        assertEquals(movieSample.movieName, movie?.movieName)

        movieViewModel.getMovieDetail(movieId).observeForever(observerMovie)
        verify(observerMovie).onChanged(movieSample)
    }

    @Test
    fun `update indicator favorite movie into favorite to true`(){
        doNothing().`when`(tmdbRepository).setFavoriteMovie(movieSample)
        tmdbRepository.setFavoriteMovie(movieSample)
        verify(tmdbRepository, times(1)).setFavoriteMovie(movieSample)
    }



}
