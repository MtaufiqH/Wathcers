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
import taufiq.apps.wathcers.repo.RemoteDataSource
import taufiq.apps.wathcers.viewmodel.sample.SampleData

/**
 * Created By Taufiq on 5/4/2021.
 */
class TvViewModelDetailTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private var tvViewModel: TvViewModelDetail? = null
    private var data = Mockito.mock(RemoteDataSource::class.java)


    @Before
    fun setUp() {
        tvViewModel = TvViewModelDetail(data)
    }

    @Test
    fun `verify tv show popular list`() {
        val id = 88396
        val sampleData = SampleData.getSampleOfDetailTvShow()
        val detailMovie = MutableLiveData(sampleData)
        Mockito.`when`(data.getDetailTv(id)).thenReturn(detailMovie)
        val dataDetails = tvViewModel?.getTvShowDetail(id)?.value
        verify(data).getDetailTv(id)
        Assert.assertNotNull(dataDetails)

        assertEquals(sampleData.name, dataDetails?.name)
        assertEquals(sampleData.backdropPath, dataDetails?.backdropPath)
        assertEquals(sampleData.overview, dataDetails?.overview)
        assertEquals(
            sampleData.genres.toString(),
            dataDetails?.genres.toString()
        )
        assertEquals(sampleData.status, dataDetails?.status)
        assertEquals(sampleData.posterPath, dataDetails?.posterPath)
        assertEquals(sampleData.lastAirDate, dataDetails?.lastAirDate)
        assertEquals(sampleData.posterPath, dataDetails?.posterPath)
        assertEquals(sampleData.originalName, dataDetails?.originalName)
        assertEquals(
            sampleData.popularity,
            dataDetails?.popularity
        )
        assertEquals(sampleData.voteAverage, dataDetails?.voteAverage)
        assertEquals(sampleData.voteCount, dataDetails?.voteCount)
        assertEquals(sampleData.homepage, dataDetails?.homepage)

    }
}