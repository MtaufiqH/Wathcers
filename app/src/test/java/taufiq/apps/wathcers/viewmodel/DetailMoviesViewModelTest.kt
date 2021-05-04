package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import taufiq.apps.wathcers.viewmodel.sample.SampleData

/**
 * Created By Taufiq on 5/3/2021.
 */
class DetailMoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private var movieViewModel: MoviesViewModelDetail? = null
    private var data = Mockito.mock(MovieRepositoryImpl::class.java)

    @Before
    fun setUp() {
        movieViewModel = MoviesViewModelDetail(data)
    }

    @Test
    fun `verify movie popular movie list`() {
        val id = 460465
        val sampleData = SampleData.getSampleOfDetailMovie()
        val detailMovie = MutableLiveData(sampleData)
        `when`(data.getDetailMovie(id)).thenReturn(detailMovie)
        val dataDetails = movieViewModel?.getMovieDetail(id)?.value
        verify(data).getDetailMovie(id)
        Assert.assertNotNull(dataDetails)

        assertEquals(sampleData.title, dataDetails?.title)
        assertEquals(sampleData.backdropPath, dataDetails?.backdropPath)
        assertEquals(sampleData.overview, dataDetails?.overview)
        assertEquals(sampleData.genres.toString(), dataDetails?.genres.toString())
        assertEquals(sampleData.status, dataDetails?.status)
        assertEquals(sampleData.posterPath, dataDetails?.posterPath)
        assertEquals(sampleData.releaseDate, dataDetails?.releaseDate)
        assertEquals(sampleData.posterPath, dataDetails?.posterPath)
        assertEquals(sampleData.originalTitle, dataDetails?.originalTitle)
        assertEquals(sampleData.originalLanguage, dataDetails?.originalLanguage)
        assertEquals(sampleData.voteAverage, dataDetails?.voteAverage)
        assertEquals(sampleData.voteCount, dataDetails?.voteCount)
        assertEquals(sampleData.homepage, dataDetails?.homepage)

    }

}
