package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.repo.RemoteDataSource
import taufiq.apps.wathcers.repo.TmdbRepository
import taufiq.apps.wathcers.viewmodel.sample.SampleData
import taufiq.apps.wathcers.vo.Resources

/**
 * Created By Taufiq on 4/17/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var tvViewModels: TvViewModel
    @Mock
    private lateinit var tmdbRepository: TmdbRepository
    @Mock
    private lateinit var observerTvShow: Observer<Resources<PagedList<TvShowEntity>>>
    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>



    @Before
    fun setUp() {
        tvViewModels = TvViewModel(tmdbRepository)
    }

    @Test
    fun `get all tv show list and verify is not null`() {
        val sampleTvShow = Resources.success(tvShowPagedList)
        `when`(sampleTvShow.data?.size).thenReturn(5)
        val tvShow = MutableLiveData<Resources<PagedList<TvShowEntity>>>()
        tvShow.value = sampleTvShow

        `when`(tmdbRepository.getTvShow()).thenReturn(tvShow)
        val tvShowEntity = tvViewModels.getTvShows().value?.data
        Mockito.verify(tmdbRepository).getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        tvViewModels.getTvShows().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(sampleTvShow)
    }

}