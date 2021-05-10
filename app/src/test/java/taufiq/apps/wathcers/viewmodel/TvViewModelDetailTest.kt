package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.repo.TmdbRepository
import taufiq.apps.wathcers.viewmodel.sample.SampleData

/**
 * Created By Taufiq on 5/4/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class TvViewModelDetailTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var tvViewModel: TvViewModelDetail

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>

    private val tvSample = SampleData.getSampleOfTvList()[0]
    private val tvId = tvSample.tvId

    @Before
    fun setUp() {
        tvViewModel = TvViewModelDetail(tmdbRepository)
    }

    @Test
    fun `verify tv show detail popular`() {
        val sampleTv = MutableLiveData<TvShowEntity>()
        sampleTv.value = tvSample
        `when`(tmdbRepository.getTvShowDetail(tvId)).thenReturn(sampleTv)
        val tvShowEntity = tvViewModel.getTvShowDetail(tvId).value
        assertNotNull(tvShowEntity)
        assertEquals(tvSample.id, tvShowEntity?.id)
        assertEquals(tvSample.tvId, tvShowEntity?.tvId)
        assertEquals(tvSample.poster, tvShowEntity?.poster)
        assertEquals(tvSample.backdrop, tvShowEntity?.backdrop)
        assertEquals(tvSample.dates, tvShowEntity?.dates)
        assertEquals(tvSample.isFavorite, tvShowEntity?.isFavorite)
        assertEquals(tvSample.desc, tvShowEntity?.desc)
        assertEquals(tvSample.ratings, tvShowEntity?.ratings)
        assertEquals(tvSample.tvName, tvShowEntity?.tvName)

        tvViewModel.getTvShowDetail(tvId).observeForever(observerTvShow)
        verify(observerTvShow).onChanged(tvSample)
    }
}